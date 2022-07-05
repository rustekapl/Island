package ru.javarush.island.bityutskih.entity;

import java.util.HashMap;

public class Deer extends Herbivores {
    private final HashMap<String, Integer> EATING = new HashMap<>();

    public Deer() {
        super();
        EATING.put(Bear.class.getCanonicalName(), 0);
        EATING.put(Boa.class.getCanonicalName(), 0);
        EATING.put(Boar.class.getCanonicalName(), 0);
        EATING.put(Buffalo.class.getCanonicalName(), 0);
        EATING.put(Caterpillar.class.getCanonicalName(), 0);
        EATING.put(Duck.class.getCanonicalName(), 0);
        EATING.put(Eagle.class.getCanonicalName(), 0);
        EATING.put(Fox.class.getCanonicalName(), 0);
        EATING.put(Goat.class.getCanonicalName(), 0);
        EATING.put(Horse.class.getCanonicalName(), 0);
        EATING.put(Mouse.class.getCanonicalName(), 0);
        EATING.put(Plant.class.getCanonicalName(), 100);
        EATING.put(Rabbit.class.getCanonicalName(), 0);
        EATING.put(Sheep.class.getCanonicalName(), 0);
        EATING.put(Wolf.class.getCanonicalName(), 0);
    }

    public float getWeight() {
        return (float) 300;
    }

    @Override
    public int getobjPerService() {
        return 20;
    }

    public int getSpeed() {
        return 4;
    }

    public float getMaxFood() {
        return (float) 50;
    }

    public HashMap<String, Integer> getEating() {
        return EATING;
    }

    public Nature getInstance() {
        return new Deer();
    }
}
