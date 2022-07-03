package ru.javarush.island.bityutskih.entity;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class Animal implements Nature {

    private final AtomicBoolean isDead = new AtomicBoolean(false);
    private float full = 0;


    public Animal() {
    }


    public abstract float getWeight();

    @Override
    public abstract int getobjPerService();

    public abstract int getSpeed();

    public abstract float getMaxFood();

    public abstract HashMap<String, Integer> getEating();


    public boolean isDead() {
        return isDead.get();
    }

    public void setDead() {
        isDead.set(true);
    }

    public float getFull() {
        return full;
    }

    public void setFull(float full) {
        this.full = full;
    }

}
