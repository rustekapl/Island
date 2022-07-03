package ru.javarush.island.pazyuk.Entity.Animal;

import ru.javarush.island.pazyuk.Entity.Entity;
import ru.javarush.island.pazyuk.Entity.EntityCreator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal extends Entity {
    private int x;
    private int y;
    private final int SPEED;
    private int energy;
    private final double HUNGER;
    private double satiety;
    private Direction cameFrom;
    private HashMap<Class<? extends Entity>, ArrayList<Entity>>[][] cells;
    private HashMap<Class<? extends Entity>, Integer> chanceToEat;

    public Animal(int x, int y, double weight, int maxCount, int speed, double hunger, HashMap<Class<? extends Entity>, Integer> chanceToEat) {
        super(weight, maxCount);
        this.x = x;
        this.y = y;
        SPEED = speed;
        energy = SPEED;
        HUNGER = hunger;
        this.chanceToEat = chanceToEat;
        this.satiety = 0.0d;
    }

    public boolean eat(Entity entity) {
        if (entity == null || !chanceToEat.keySet().contains(entity.getClass())) {
            throw new RuntimeException("Missing food");
        }
        if (!isHungry()) return false;
        double newSatiety = satiety + entity.getWeight();
        if (newSatiety > HUNGER) satiety = HUNGER;
        else satiety = newSatiety;
        return entity.die();
    }

    public Animal mate(Animal animal) {
        if (animal == null || this == animal || getClass() != animal.getClass()) {
            throw new RuntimeException("An animal cannot mate without a partner");
        }
        satiety = 0.0d;
        animal.satiety = 0.0d;
        return EntityCreator.create(getClass(), getX(), getY());
    }

    public boolean move(HashMap<Class<? extends Entity>, ArrayList<Entity>>[][] cells) {
        if (cells == null) throw new RuntimeException("Missing map");
        if (energy <= 0) return false;
        this.cells = cells;
        ArrayList<Direction> directions = new ArrayList<>(Arrays.asList(Direction.values()));
        Direction direction;
        boolean isMoved = false;
        while (!isMoved && directions.size() != 0) {
            direction = directions.get(ThreadLocalRandom.current().nextInt(0, directions.size()));
            if (direction == Direction.UP) {
                if (cameFrom == Direction.UP && directions.size() > 1) {
                    direction = directions.get(ThreadLocalRandom.current().nextInt(0, directions.size()));
                } else {
                    cameFrom = Direction.DOWN;
                    directions.remove(direction);
                    isMoved = move(0, -1);
                }
            } else if (direction == Direction.RIGHT) {
                if (cameFrom == Direction.RIGHT && directions.size() > 1) {
                    direction = directions.get(ThreadLocalRandom.current().nextInt(0, directions.size()));
                } else {
                    cameFrom = Direction.LEFT;
                    directions.remove(direction);
                    isMoved = move(1, 0);
                }
            } else if (direction == Direction.DOWN) {
                if (cameFrom == Direction.DOWN && directions.size() > 1) {
                    direction = directions.get(ThreadLocalRandom.current().nextInt(0, directions.size()));
                } else {
                    cameFrom = Direction.UP;
                    directions.remove(direction);
                    isMoved = move(0, 1);
                }
            } else if (direction == Direction.LEFT) {
                if (cameFrom == Direction.LEFT && directions.size() > 1) {
                    direction = directions.get(ThreadLocalRandom.current().nextInt(0, directions.size()));
                } else {
                    cameFrom = Direction.RIGHT;
                    directions.remove(direction);
                    isMoved = move(-1, 0);
                }
            }
        }
        return isMoved;
    }

    private boolean move(int x, int y) {
        int newX = this.x + x;
        int newY = this.y + y;
        if ((cells.length > newX && newX >= 0) && (cells[newX].length > newY && newY >= 0)) {
            if (cells[newX][newY].get(getClass()).size() >= getMaxCount()) return false;
            boolean isDeleted = cells[this.x][this.y].get(getClass()).remove(this);
            boolean isAdded = cells[newX][newY].get(getClass()).add(this);
            boolean isMoved = isDeleted && isAdded;
            if (isMoved) {
                this.x = newX;
                this.y = newY;
                cells = null;
                --energy;
            }
            return isMoved;
        } else {
            return false;
        }
    }

    public boolean sleep() {
        if (energy != SPEED || satiety != 0.0d) {
            energy = SPEED;
            satiety = 0.0d;
            return true;
        } else {
            return false;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return SPEED;
    }

    public boolean isHungry() {
        return satiety < HUNGER;
    }

    public HashMap<Class<? extends Entity>, Integer> getChanceToEat() {
        return chanceToEat;
    }

    public enum Direction {
        UP,
        RIGHT,
        DOWN,
        LEFT
    }
}
