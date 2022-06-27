package ru.javarush.island.pazyuk;

import ru.javarush.island.pazyuk.Entity.Animal.Animal;
import ru.javarush.island.pazyuk.Entity.Entity;
import ru.javarush.island.pazyuk.Entity.EntityCreator;
import ru.javarush.island.pazyuk.Entity.Plant.Plant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public final class LifeSimulator {
    //TODO Code style. Many warnings. Skip or fix it.
    private HashMap<Class<? extends Entity>, ArrayList<Entity>>[][] cells;
    private final ArrayList<Entity> ALL_ANIMALS = new ArrayList<>();
    private final ArrayList<HashMap<Class<? extends Plant>, ArrayList<Entity>>> ALL_PLANTS = new ArrayList<>();

    public LifeSimulator(Island island) {
        cells = island.getCells();
        generateEntities();
    }

    private void simulate() {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(3);
        ses.scheduleWithFixedDelay(() -> printStatistic(), 0, 1, TimeUnit.SECONDS);
        ses.scheduleWithFixedDelay(() -> plantGrowth(), 0, 1, TimeUnit.SECONDS);
        ses.scheduleWithFixedDelay(() -> animalActivity(), 0, 1, TimeUnit.SECONDS);
        while (true) {
            if (ALL_ANIMALS.isEmpty()) {
                ses.shutdown();
                break;
            } else {
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private void printStatistic() {
        for (Class<? extends Entity> entity : EntityCreator.getAllEntities()) {
            int count = 0;
            for (int x = 0; x < cells.length; ++x) {
                for (int y = 0; y < cells[x].length; ++y) {
                    count += cells[x][y].get(entity).size();
                }
            }
            System.out.println(entity.getSimpleName() + ": " + count);
        }
        System.out.println();
        System.out.println("******************************");
        System.out.println();
    }

    private void generateEntities() {
        for (int x = 0; x < cells.length; ++x) {
            for (int y = 0; y < cells[x].length; ++y) {
                HashMap<Class<? extends Entity>, ArrayList<Entity>> cell = new HashMap<>();
                for (Class<? extends Animal> species : EntityCreator.getAllAnimals()) {
                    ArrayList<Entity> animals = new ArrayList<>();
                    int random = ThreadLocalRandom.current().nextInt(0, EntityCreator.create(species, x, y).getMaxCount() + 1);
                    for (int i = 0; i < random; ++i) {
                        animals.add(EntityCreator.create(species, x, y));
                    }
                    ALL_ANIMALS.addAll(animals);
                    cell.put(species, animals);
                }
                for (Class<? extends Plant> species : EntityCreator.getAllPlants()) {
                    ArrayList<Entity> plants = new ArrayList<>();
                    int random = ThreadLocalRandom.current().nextInt(0, EntityCreator.create(species).getMaxCount() + 1);
                    for (int i = 0; i < random; ++i) {
                        plants.add(EntityCreator.create(species));
                    }
                    ALL_PLANTS.add(new HashMap<>() {{
                        put(species, plants);
                    }});
                    cell.put(species, plants);
                }
                cells[x][y] = cell;
            }
        }
    }

    private void plantGrowth() {
        Collections.shuffle(ALL_PLANTS);
        for (HashMap<Class<? extends Plant>, ArrayList<Entity>> plantType : ALL_PLANTS) {
            for (Class<? extends Plant> plant : plantType.keySet()) {
                int population = plantType.get(plant).size();
                int maxCount = EntityCreator.create(plant).getMaxCount();
                if (population < maxCount) {
                    int random = ThreadLocalRandom.current().nextInt(0, maxCount + 1);
                    if (random > maxCount - population) random = maxCount - population;
                    for (int i = 0; i < random; ++i) {
                        plantType.get(plant).add(EntityCreator.create(plant));
                    }
                }
            }
        }
    }

    private void animalActivity() {
        Collections.shuffle(ALL_ANIMALS);
        for (int i = 0; i < ALL_ANIMALS.size(); ) {
            Animal animal = (Animal) ALL_ANIMALS.get(i);
            if (animal.isAlive()) {
                if (animal.isHungry()) {
                    if (!searchForFood(animal)) {
                        animal.die();
                        continue;
                    }
                }
                if (!animal.isHungry()) {
                    searchForAPartner(animal);
                }
                ++i;
            } else {
                cells[animal.getX()][animal.getY()].get(animal.getClass()).remove(animal);
                ALL_ANIMALS.remove(i);
            }
        }
        for (Entity entity : ALL_ANIMALS) {
            Animal animal = (Animal) entity;
            animal.sleep();
        }
    }

    private boolean searchForFood(Animal animal) {
        //TODO Code style. Long code. Needs to be split into several methods
        HashMap<Class<? extends Entity>, Integer> chanceToEat = animal.getChanceToEat();
        ArrayList<Class<? extends Entity>> diet = new ArrayList<>(chanceToEat.keySet());
        HashMap<Class<? extends Entity>, ArrayList<Entity>> cell = cells[animal.getX()][animal.getY()];
        ArrayList<Entity> preys = new ArrayList<>();
        for (Class<? extends Entity> preference : diet) {
            preys.addAll(cell.get(preference));
        }
        Collections.shuffle(preys);
        for (int i = 0; animal.isHungry(); ) {
            if (i >= preys.size()) {
                i = 0;
                if (animal.move(cells)) {
                    cell = cells[animal.getX()][animal.getY()];
                    preys = new ArrayList<>();
                    for (Class<? extends Entity> preference : diet) {
                        preys.addAll(cell.get(preference));
                    }
                    Collections.shuffle(preys);
                } else {
                    return false;
                }
            }
            if (preys.isEmpty()) {
                if (animal.move(cells)) {
                    cell = cells[animal.getX()][animal.getY()];
                    preys = new ArrayList<>();
                    for (Class<? extends Entity> preference : diet) {
                        preys.addAll(cell.get(preference));
                    }
                    Collections.shuffle(preys);
                } else {
                    return false;
                }
            } else {
                Entity prey = preys.get(i);
                int random = ThreadLocalRandom.current().nextInt(1, 100 + 1);
                int chance = chanceToEat.get(prey.getClass());
                if (random <= chance) {
                    boolean preyIsDead = animal.eat(prey);
                    if (preyIsDead) {
                        cells[animal.getX()][animal.getY()].get(prey.getClass()).remove(prey);
                    }
                } else {
                    ++i;
                }
            }
        }
        return true;
    }

    private boolean searchForAPartner(Animal animal) {
        //TODO Code style. Long code. Needs to be split into several methods
        ArrayList<Entity> animals = cells[animal.getX()][animal.getY()].get(animal.getClass());
        while (!animal.isHungry()) {
            if (animals.isEmpty() || animals.size() >= animal.getMaxCount()) {
                if (animal.move(cells)) {
                    animals = cells[animal.getX()][animal.getY()].get(animal.getClass());
                } else {
                    return false;
                }
            } else {
                for (int i = 0; i < animals.size(); ++i) {
                    Animal partner = (Animal) animals.get(i);
                    if (!partner.isHungry() && partner != animal) {
                        Animal child = animal.mate(partner);
                        animals.add(child);
                        ALL_ANIMALS.add(child);
                        return true;
                    }
                }
                if (animal.move(cells)) {
                    animals = cells[animal.getX()][animal.getY()].get(animal.getClass());
                } else {
                    return false;
                }
            }
        }
        return !animal.isHungry();
    }

    public static void main(String[] args) {
        LifeSimulator simulator = new LifeSimulator(Island.getIsland());
        simulator.simulate();
    }
}
