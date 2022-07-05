package ru.javarush.island.bityutskih.entity;

import java.util.HashMap;

public class Eagle extends Predators {
    private final HashMap<String, Integer> EATING = new HashMap<>();

    public Eagle() {
        super();
        EATING.put(Bear.class.getCanonicalName(), 0);
        EATING.put(Boa.class.getCanonicalName(), 0);
        EATING.put(Boar.class.getCanonicalName(), 0);
        EATING.put(Buffalo.class.getCanonicalName(), 0);
        EATING.put(Caterpillar.class.getCanonicalName(), 0);
        EATING.put(Deer.class.getCanonicalName(), 0);
        EATING.put(Duck.class.getCanonicalName(), 80);
        EATING.put(Fox.class.getCanonicalName(), 10);
        EATING.put(Goat.class.getCanonicalName(), 0);
        EATING.put(Horse.class.getCanonicalName(), 0);
        EATING.put(Mouse.class.getCanonicalName(), 90);
        EATING.put(Plant.class.getCanonicalName(), 0);
        EATING.put(Rabbit.class.getCanonicalName(), 90);
        EATING.put(Sheep.class.getCanonicalName(), 0);
        EATING.put(Wolf.class.getCanonicalName(), 0);
    }

    public float getWeight() {
        return (float) 6;
    }

    @Override
    public int getobjPerService() {
        return 20;
    }

    public int getSpeed() {
        return 3;
    }

    public float getMaxFood() {
        return (float) 1;
    }

    public HashMap<String, Integer> getEating() {
        return EATING;
    }

    public Nature getInstance() {
        return new Eagle();
    }
}