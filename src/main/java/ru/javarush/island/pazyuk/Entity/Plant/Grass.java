package ru.javarush.island.pazyuk.Entity.Plant;

public class Grass extends Plant {
    private static final double WEIGHT = 1.0d;
    private static final int MAX_COUNT = 200;

    public Grass() {
        super(WEIGHT, MAX_COUNT);
    }
}
