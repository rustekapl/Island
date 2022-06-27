package ru.javarush.island.khryukin.entity.animals.organisms;

public class Limit {
    private double maxWeight = 0;
    private int maxCount = 0;
    private int maxSpeed = 0;
    private int maxFood = 0;

    public Limit(double maxWeight, int maxCount, int maxSpeed, int maxFood) {
        this.maxWeight = maxWeight;
        this.maxCount = maxCount;
        this.maxSpeed = maxSpeed;
        this.maxFood = maxFood;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getMaxFood() {
        return maxFood;
    }
}
