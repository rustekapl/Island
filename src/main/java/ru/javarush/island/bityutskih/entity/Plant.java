package ru.javarush.island.bityutskih.entity;

import java.util.concurrent.atomic.AtomicBoolean;

public class Plant implements Nature {
    private final AtomicBoolean isDead = new AtomicBoolean(false);

    public float getWeight() {
        return (float) 1;
    }

    @Override
    public boolean isDead() {
        return false;
    }

    @Override
    public int getobjPerService() {
        return 200;
    }

    public void setDead() {
        isDead.set(true);
    }

    @Override
    public Nature getInstance() {
        return new Plant();
    }

    @Override
    public String toString() {
        return "Plant";
    }
}