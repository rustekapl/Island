package ru.javarush.island.bityutskih.entity;

import java.util.HashMap;

public class Duck extends Herbivores {
    private final HashMap<String, Integer> EATING = new HashMap<>();

    public Duck() {
        super();
        EATING.put(Bear.class.getCanonicalName(), 0);
        EATING.put(Boa.class.getCanonicalName(), 0);
        EATING.put(Boar.class.getCanonicalName(), 0);
        EATING.put(Buffalo.class.getCanonicalName(), 0);
        EATING.put(Caterpillar.class.getCanonicalName(), 90);
        EATING.put(Deer.class.getCanonicalName(), 0);
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
        return (float) 1;
    }

    @Override
    public int getobjPerService() {
        return 200;
    }

    public int getSpeed() {
        return 4;
    }

    public float getMaxFood() {
        return 0.15F;
    }

    public HashMap<String, Integer> getEating() {
        return EATING;
    }

    public Nature getInstance() {
        return new Duck();
    }
}
