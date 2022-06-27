package ru.javarush.island.pazyuk.Entity.Animal.Herbivore;

import ru.javarush.island.pazyuk.Entity.Plant.Grass;

import java.util.HashMap;

public class Caterpillar extends Herbivore {
    private static final double WEIGHT = 0.01d;
    private static final int MAX_COUNT = 1000;
    private static final int SPEED = 0;
    private static final double HUNGER = 0.0d;

    public Caterpillar(int x, int y) {
        super(x, y, WEIGHT, MAX_COUNT, SPEED, HUNGER, new HashMap<>() {{
            put(Grass.class, 100);
        }});
    }
}
