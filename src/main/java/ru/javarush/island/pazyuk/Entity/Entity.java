package ru.javarush.island.pazyuk.Entity;

public abstract class Entity {
    private final double WEIGHT;
    private final int MAX_COUNT;

    private boolean isAlive;

    public Entity(double weight, int maxCount) {
        WEIGHT = weight;
        MAX_COUNT = maxCount;
        this.isAlive = true;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public boolean die() {
        return !(isAlive = false);
    }

    public double getWeight() {
        return WEIGHT;
    }

    public int getMaxCount() {
        return MAX_COUNT;
    }
}
