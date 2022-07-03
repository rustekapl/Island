package ru.javarush.island.zazimko.classes.animals;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Type;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Getter
@Setter
@AllArgsConstructor
public abstract class Organism {
    private final static AtomicLong idCounter = new AtomicLong(System.currentTimeMillis());
    private final long id = idCounter.incrementAndGet();
    private String name;
    private double weight;
    private double maxWeight;
    private double satiety;
    private int maxValueOfEntity;
    private int speed;
    private String icon;
    private final String type = this
            .getClass()
            .getSimpleName();
    private transient final String letter = type.substring(0, 1);
    public ConcurrentHashMap<Type, Integer> initializedRation;


    protected Organism() {
    }
}
