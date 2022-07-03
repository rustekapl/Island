package ru.javarush.island.bityutskih.entity;


import java.util.HashMap;

public class Fox extends Predators {
    private final HashMap<String, Integer> EATING = new HashMap<>();

    public Fox() {
        super();
        EATING.put(Bear.class.getCanonicalName(), 0);
        EATING.put(Boa.class.getCanonicalName(), 0);
        EATING.put(Boar.class.getCanonicalName(), 0);
        EATING.put(Buffalo.class.getCanonicalName(), 0);
        EATING.put(Caterpillar.class.getCanonicalName(), 40);
        EATING.put(Deer.class.getCanonicalName(), 0);
        EATING.put(Duck.class.getCanonicalName(), 60);
        EATING.put(Eagle.class.getCanonicalName(), 0);
        EATING.put(Goat.class.getCanonicalName(), 0);
        EATING.put(Horse.class.getCanonicalName(), 0);
        EATING.put(Mouse.class.getCanonicalName(), 90);
        EATING.put(Plant.class.getCanonicalName(), 0);
        EATING.put(Rabbit.class.getCanonicalName(), 70);
        EATING.put(Sheep.class.getCanonicalName(), 0);
        EATING.put(Wolf.class.getCanonicalName(), 0);
    }

    public float getWeight() {
        return (float) 8;
    }

    @Override
    public int getobjPerService() {
        return 30;
    }

    public int getSpeed() {
        return 2;
    }

    public float getMaxFood() {
        return (float) 2;
    }

    public HashMap<String, Integer> getEating() {
        return EATING;
    }


    public Nature getInstance() {
        return new Fox();
    }
}
