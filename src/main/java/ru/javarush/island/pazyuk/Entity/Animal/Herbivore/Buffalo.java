package ru.javarush.island.pazyuk.Entity.Animal.Herbivore;

import ru.javarush.island.pazyuk.Entity.Plant.Grass;

import java.util.HashMap;

public class Buffalo extends Herbivore {
    private static final double WEIGHT = 700.0d;
    private static final int MAX_COUNT = 10;
    private static final int SPEED = 3;
    private static final double HUNGER = 100.0d;

    public Buffalo(int x, int y) {
        super(x, y, WEIGHT, MAX_COUNT, SPEED, HUNGER, new HashMap<>() {{
            put(Grass.class, 100);
        }});
    }
}
