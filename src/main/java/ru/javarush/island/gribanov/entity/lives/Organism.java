package ru.javarush.island.gribanov.entity.lives;

import ru.javarush.island.gribanov.abstraction.entity.Reproducible;
import ru.javarush.island.gribanov.entity.map.Cell;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;
@SuppressWarnings("unused")
public abstract class Organism implements Reproducible, Serializable, Cloneable {

    private final static AtomicLong idCounter = new AtomicLong(System.currentTimeMillis());
    private final String name;

    private final String type = this.getClass().getSimpleName();
    private long id = idCounter.incrementAndGet();
    private final String icon;
    private double weight;
    private boolean isALive = true;

    protected final Limit LIMIT;

    public Organism(String name, String icon, double weight, Limit limit) {
        this.name = name;
        this.icon = icon;
        this.weight = weight;
        this.LIMIT = limit;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Limit getLimit() {
        return LIMIT;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isALive() {
        return isALive;
    }

    public void setWeight(double weight) {
        this.weight = weight;
        if (weight <= LIMIT.getMIN_WEIGHT()){
            this.isALive = false;
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Organism clone = (Organism) super.clone();
        clone.id = idCounter.incrementAndGet();
        clone.weight = LIMIT.getMAX_WEIGHT();
        return clone;
    }

    @SuppressWarnings("unchecked")
    public static <T extends Organism> T replicate(T original) {
        try {
            return (T) original.clone();
        } catch (CloneNotSupportedException|ClassCastException e) {
            throw new AssertionError(e);
        }
    }

    public void safeDie(Cell target) {
        target.getLock().lock();
        try {
            if (!this.isALive) {
                target.getResidents().get(type).remove(this);
            }
        } finally {
            target.getLock().unlock();
        }
    }

    public String getIcon() {
        return icon;
    }
}
