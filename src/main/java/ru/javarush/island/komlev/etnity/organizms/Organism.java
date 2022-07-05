package ru.javarush.island.komlev.etnity.organizms;

import ru.javarush.island.komlev.abstraction.interfaces.Reproducible;

import java.util.concurrent.atomic.AtomicLong;

public abstract class Organism implements Reproducible, Cloneable {
    //паспорт животного
    private final static AtomicLong idCounter = new AtomicLong(System.currentTimeMillis());
    private final long id = idCounter.incrementAndGet();
    private final String type = this.getClass().getSimpleName();
    private String name;
    private String icon;
    private double weight;
    private Limit limit;

    public Organism(String name, String icon, double weight, Limit limit) {
        this.name = name;
        this.icon = icon;
        this.weight = weight;
        this.limit = limit;
    }


    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Limit getLimit() {
        return limit;
    }

    public void setLimit(Limit limit) {
        this.limit = limit;
    }


    @Override
    public Organism clone() {
        try {
            return (Organism) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("cannot clone " + this);
        }
    }

    @Override
    public String toString() {
        return icon;
    }
}
