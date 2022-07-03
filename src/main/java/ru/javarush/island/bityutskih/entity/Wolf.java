package ru.javarush.island.bityutskih.entity;

import java.util.HashMap;

public class Wolf extends Predators {
    private final HashMap<String, Integer> EATING = new HashMap<>();

    public Wolf() {
        super();
        EATING.put(Bear.class.getCanonicalName(), 0);
        EATING.put(Boa.class.getCanonicalName(), 0);
        EATING.put(Boar.class.getCanonicalName(), 15);
        EATING.put(Buffalo.class.getCanonicalName(), 10);
        EATING.put(Caterpillar.class.getCanonicalName(), 0);
        EATING.put(Deer.class.getCanonicalName(), 15);
        EATING.put(Duck.class.getCanonicalName(), 40);
        EATING.put(Eagle.class.getCanonicalName(), 0);
        EATING.put(Fox.class.getCanonicalName(), 0);
        EATING.put(Goat.class.getCanonicalName(), 60);
        EATING.put(Horse.class.getCanonicalName(), 10);
        EATING.put(Mouse.class.getCanonicalName(), 80);
        EATING.put(Plant.class.getCanonicalName(), 0);
        EATING.put(Rabbit.class.getCanonicalName(), 60);
        EATING.put(Sheep.class.getCanonicalName(), 70);
    }

    public float getWeight() {
        return (float) 50;
    }

    @Override
    public int getobjPerService() {
        return 30;
    }

    public int getSpeed() {
        return 3;
    }

    public float getMaxFood() {
        return (float) 8;
    }

    public HashMap<String, Integer> getEating() {
        return EATING;
    }

    public Nature getInstance() {
        return new Wolf();
    }

    @Override
    public String toString() {
        return "Wolf";
    }
}
