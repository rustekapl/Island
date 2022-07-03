package ru.javarush.island.smulko.entity.preferences;

public class Fields {
    private final String name;
    private final String icon;
    private final double maxWeight;
    private final int speed;
    private final int maxCountOnCell;

    public Fields(String name, String icon, double maxWeight, int speed, int maxCountOnCell) {
        this.name = name;
        this.icon = icon;
        this.maxWeight = maxWeight;
        this.speed = speed;
        this.maxCountOnCell = maxCountOnCell;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public int getSpeed() {
        return speed;
    }

    public int getMaxCountOnCell() {
        return maxCountOnCell;
    }
}
