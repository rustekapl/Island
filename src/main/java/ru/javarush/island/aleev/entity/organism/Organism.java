package ru.javarush.island.aleev.entity.organism;


import ru.javarush.island.aleev.interfaces.Reproductable;
import ru.javarush.island.aleev.parameters.Parameters;


public abstract class Organism implements Reproductable {
    private final String name;
    private final String icon;
    private final double weight;
    private final double maxWeight;
    private final int maxCount;
    private final int maxSpeed;
    private final double maxFood;


    public Organism(Parameters parameters) {
        this.name = parameters.getName();
        this.icon = parameters.getIcon();
        this.weight = parameters.getWeight();
        this.maxWeight = parameters.getMaxWeight();
        this.maxCount = parameters.getMaxCount();
        this.maxSpeed = parameters.getMaxSpeed();
        this.maxFood = parameters.getMaxFood();
    }

    @Override
    public void reproduct() {

    }

    @Override
    public String toString() {
        return icon;
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
