package ru.javarush.island.bityutskih.entity;


import java.util.HashMap;

public class Bear extends Predators {
    private final HashMap<String, Integer> EATING = new HashMap<>();


    public Bear() {
        super();
        EATING.put(Boa.class.getCanonicalName(), 80);
        EATING.put(Boar.class.getCanonicalName(), 50);
        EATING.put(Buffalo.class.getCanonicalName(), 20);
        EATING.put(Caterpillar.class.getCanonicalName(), 0);
        EATING.put(Deer.class.getCanonicalName(), 80);
        EATING.put(Duck.class.getCanonicalName(), 10);
        EATING.put(Eagle.class.getCanonicalName(), 0);
        EATING.put(Fox.class.getCanonicalName(), 0);
        EATING.put(Goat.class.getCanonicalName(), 70);
        EATING.put(Horse.class.getCanonicalName(), 40);
        EATING.put(Mouse.class.getCanonicalName(), 90);
        EATING.put(Plant.class.getCanonicalName(), 0);
        EATING.put(Rabbit.class.getCanonicalName(), 80);
        EATING.put(Sheep.class.getCanonicalName(), 70);
        EATING.put(Wolf.class.getCanonicalName(), 0);

    }


    @Override
    public float getWeight() {
        return 0;
    }

    @Override
    public int getobjPerService() {
        return 0;
    }

    @Override
    public int getSpeed() {
        return 0;
    }

    @Override
    public float getMaxFood() {
        return 0;
    }

    @Override
    public HashMap<String, Integer> getEating() {
        return null;
    }


    public HashMap<String, Integer> getEATING() {
        return EATING;
    }

    @Override
    public Nature getInstance() {
        return new Bear();
    }
}
