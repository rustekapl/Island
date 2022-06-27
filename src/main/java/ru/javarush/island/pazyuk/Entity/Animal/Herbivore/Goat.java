package ru.javarush.island.pazyuk.Entity.Animal.Herbivore;

import ru.javarush.island.pazyuk.Entity.Plant.Grass;

import java.util.HashMap;

public class Goat extends Herbivore {
    private static final double WEIGHT = 60.0d;
    private static final int MAX_COUNT = 140;
    private static final int SPEED = 3;
    private static final double HUNGER = 10.0d;

    public Goat(int x, int y) {
        super(x, y, WEIGHT, MAX_COUNT, SPEED, HUNGER, new HashMap<>() {{
            put(Grass.class, 100);
        }});
    }
}
