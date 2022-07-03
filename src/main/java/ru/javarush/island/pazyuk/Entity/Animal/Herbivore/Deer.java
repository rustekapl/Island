package ru.javarush.island.pazyuk.Entity.Animal.Herbivore;

import ru.javarush.island.pazyuk.Entity.Plant.Grass;

import java.util.HashMap;

public class Deer extends Herbivore {
    private static final double WEIGHT = 300.0d;
    private static final int MAX_COUNT = 20;
    private static final int SPEED = 4;
    private static final double HUNGER = 50.0d;

    public Deer(int x, int y) {
        super(x, y, WEIGHT, MAX_COUNT, SPEED, HUNGER, new HashMap<>() {{
            put(Grass.class, 100);
        }});
    }
}
