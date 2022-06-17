package com.javarush.island.khmelov.entity.organizms;

import com.javarush.island.khmelov.abstraction.entity.Reproducible;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicLong;

@SuppressWarnings("unused")
@Getter
public abstract class Organism implements Reproducible, Cloneable {

    private final static AtomicLong idCounter = new AtomicLong(System.currentTimeMillis());

    public Organism(String name, String icon, double weight, Limit limit) {
        this.name = name;
        this.icon = icon;
        this.weight = weight;
        this.limit = limit;
    }

    private long id = idCounter.incrementAndGet();
    private final String name;
    private final String icon;
    @Setter
    private double weight;
    private final Limit limit;

    @Override
    public String toString() {
        return icon;
    }

    @Override
    protected Organism clone() throws CloneNotSupportedException {
        //visible in inherits (cast to Organism)
        Organism clone = (Organism) super.clone();
        clone.id = idCounter.incrementAndGet();
        return clone;
    }

    @SuppressWarnings("unchecked")
    public static <T extends Organism> T clone(T original) {
        //for clients (cast to original Type)
        try {
            Organism clone = original.clone();
            return (T) clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }

    }
}
