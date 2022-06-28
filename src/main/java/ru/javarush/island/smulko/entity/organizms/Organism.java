package ru.javarush.island.smulko.entity.organizms;

import ru.javarush.island.smulko.entity.preferences.Fields;

public abstract class Organism implements Cloneable {

    private final String name;
    private final String icon;
    private final double weight;
    private final int speed;
    private final int maxCountOnCell;


    public Organism(Fields fields) {
        this.name = fields.getName();
        this.icon = fields.getIcon();
        this.weight = fields.getMaxWeight();
        this.speed = fields.getSpeed();
        this.maxCountOnCell = fields.getMaxCountOnCell();
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

    public int getSpeed() {
        return speed;
    }

    public int getMaxCountOnCell() {
        return maxCountOnCell;
    }

    @Override
    public String toString() {
        return icon;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
