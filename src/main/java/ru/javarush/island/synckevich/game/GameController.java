package ru.javarush.island.synckevich.game;

import ru.javarush.island.synckevich.entities.Entity;
import ru.javarush.island.synckevich.entities.animals.Animal;
import ru.javarush.island.synckevich.enums.Action;
import ru.javarush.island.synckevich.enums.Direction;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class GameController {
    public static final AtomicInteger DAY_NUMBER = new AtomicInteger(0);
    private final GameField field;
    private final GameStats stats;
    private final ExecutorService cellRunExecutor;

    public GameController(GameField field) {
        this.field = field;
        this.stats = new GameStats(field);
        this.cellRunExecutor = Executors.newWorkStealingPool();
    }

    public Runnable createLifeCycleTask() {
        return () -> {
            int y;

            for (y = 0; y < this.field.getHeight(); ++y) {

                for (int x = 0; x < this.field.getWidth(); ++x) {
                    Cell cell = this.field.getCells()[y][x];
                    this.cellRunExecutor.submit(this.createCellTask(cell));
                }

            }

            y = DAY_NUMBER.getAndIncrement();

            if (this.isEndLifeCycle(y)) {
                this.stopSimulation();
            }

        };
    }

    public GameField getField() {
        return this.field;
    }

    public GameStats getStats() {
        return this.stats;
    }

    private Runnable createCellTask(Cell cell) {
        return () -> {
            List<Animal> animals = new CopyOnWriteArrayList<>(cell.getAnimals());

            for (Animal animal : animals) {

                if (this.isDead(animal)) {
                    cell.removeEntity(animal);
                } else {
                    Action action = animal.chooseAction();
                    this.doAction(action, animal, cell);
                }
            }
        };
    }

    private void stopSimulation() {
        Game.executorService.shutdown();
    }

    private boolean isEndLifeCycle(int currentDay) {
        return currentDay >= GameSettings.MAX_NUMBER_OF_DAYS;
    }

    private void reduceHealth(Animal animal) {
        double healthPoints = animal.getHealthPoints() - animal.getHungryPoints()
                * GameSettings.REDUCE_HEALTH_PERCENT / 100.0;
        animal.setHealthPoints(healthPoints);
    }

    private void increaseHealth(Animal animal) {
        double healthPoints = animal.getHealthPoints() + animal.getHungryPoints()
                * GameSettings.INCREASE_HEALTH_PERCENT / 100.0;

        if (healthPoints > animal.getHealthPoints()) {
            healthPoints = animal.getHungryPoints();
        }

        animal.setHealthPoints(healthPoints);
    }

    private void doEat(Animal animal, Cell cell) {
        List<Entity> entities = cell.getEntities();

        List<Entity> foodEntities = entities.stream()
                .filter(food ->
                        !Objects.equals(food.getClass().getSimpleName(), animal.getClass().getSimpleName()))
                .toList();

        if (!foodEntities.isEmpty()) {
            Entity foodEntity = foodEntities.get(ThreadLocalRandom.current().nextInt(foodEntities.size()));

            if (animal.eat(foodEntity)) {
                cell.removeEntity(foodEntity);
            }

        }
    }

    private void doProduce(Animal animal, Cell cell) {
        List<Animal> animals = cell.getAnimals();

        List<Animal> sameAnimalType = animals.stream()
                .filter(animalType ->
                        Objects.equals(animalType.getClass().getSimpleName(), animal.getClass().getSimpleName()))
                .toList();

        if (sameAnimalType.size() > 1) {
            Animal newAnimal = animal.reproduce();
            cell.addEntity(newAnimal);
        }

    }

    private void doMove(Animal animal, Cell cell) {

        for (int stepsCount = Randomizer.get(animal.getSpeed() + 1); stepsCount > 0; --stepsCount) {
            Direction direction = animal.chooseDirection();

            switch (direction) {
                case DOWN -> this.stepDown(animal, cell);
                case UP -> this.stepUp(animal, cell);
                case LEFT -> this.stepLeft(animal, cell);
                case RIGHT -> this.stepRight(animal, cell);
            }

        }
    }

    private void doSleep(Animal animal) {
        this.increaseHealth(animal);
    }

    private void doAction(Action action, Animal animal, Cell cell) {

        switch (action) {
            case MOVE -> this.doMove(animal, cell);
            case EAT -> this.doEat(animal, cell);
            case REPRODUCE -> this.doProduce(animal, cell);
            case SLEEP -> this.doSleep(animal);
        }

        this.reduceHealth(animal);
    }

    private boolean isDead(Animal animal) {
        return animal.getHealthPoints() < 0.0;
    }

    private void stepUp(Animal animal, Cell currentCell) {
        int currentX = currentCell.getRow();
        int currentY = currentCell.getColumn();

        if (currentY < this.field.getHeight() - 1) {
            Cell newCell = this.field.getCells()[currentY + 1][currentX];
            newCell.addEntity(animal);
            currentCell.removeEntity(animal);
        }

    }

    private void stepDown(Animal animal, Cell currentCell) {
        int currentX = currentCell.getRow();
        int currentY = currentCell.getColumn();

        if (currentY > 0) {
            Cell newCell = this.field.getCells()[currentY - 1][currentX];
            newCell.addEntity(animal);
            currentCell.removeEntity(animal);
        }

    }

    private void stepLeft(Animal animal, Cell currentCell) {
        int currentX = currentCell.getRow();
        int currentY = currentCell.getColumn();

        if (currentX > 0) {
            Cell newCell = this.field.getCells()[currentY][currentX - 1];
            newCell.addEntity(animal);
            currentCell.removeEntity(animal);
        }

    }

    private void stepRight(Animal animal, Cell currentCell) {
        int currentX = currentCell.getRow();
        int currentY = currentCell.getColumn();

        if (currentX < this.field.getWidth() - 1) {
            Cell newCell = this.field.getCells()[currentY][currentX + 1];
            newCell.addEntity(animal);
            currentCell.removeEntity(animal);
        }

    }
}
