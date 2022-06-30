package ru.javarush.island.aleev.parameters;


public class Parameters {
    private final String name;
    private final String icon;
    private final double weight;
    private final double maxWeight;
    private final int maxCount;
    private final int maxSpeed;
    private final double maxFood;

    public Parameters(String name, String icon, double weight, double maxWeight, int maxCount, int maxSpeed, double maxFood) {
        this.name = name;
        this.icon = icon;
        this.weight = weight;
        this.maxWeight = maxWeight;
        this.maxCount = maxCount;
        this.maxSpeed = maxSpeed;
        this.maxFood = maxFood;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public double getWeight() {
        return weight;
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

    public double getMaxFood() {
        return maxFood;
    }
}
