package ru.javarush.island.bityutskih.entity;


import java.util.HashMap;

public class Boa extends Predators {
    private final HashMap<String, Integer> EATING = new HashMap<>();

    public Boa() {
        super();
        //TODO Coding. Hard code. Not flexible
        EATING.put(Bear.class.getCanonicalName(), 0);
        EATING.put(Boar.class.getCanonicalName(), 0);
        EATING.put(Buffalo.class.getCanonicalName(), 0);
        EATING.put(Caterpillar.class.getCanonicalName(), 0);
        EATING.put(Deer.class.getCanonicalName(), 0);
        EATING.put(Duck.class.getCanonicalName(), 10);
        EATING.put(Eagle.class.getCanonicalName(), 0);
        EATING.put(Fox.class.getCanonicalName(), 15);
        EATING.put(Goat.class.getCanonicalName(), 0);
        EATING.put(Horse.class.getCanonicalName(), 0);
        EATING.put(Mouse.class.getCanonicalName(), 40);
        EATING.put(Plant.class.getCanonicalName(), 0);
        EATING.put(Rabbit.class.getCanonicalName(), 20);
        EATING.put(Sheep.class.getCanonicalName(), 0);
        EATING.put(Wolf.class.getCanonicalName(), 0);
    }

    public float getWeight() {
        return (float) 15;
    }

    @Override
    public int getobjPerService() {
        return 30;
    }

    public int getSpeed() {
        return 1;
    }

    public float getMaxFood() {
        return (float) 3;
    }

    public HashMap<String, Integer> getEating() {
        return EATING;
    }

    @Override
    public Nature getInstance() {
        return new Boa();
    }


}
