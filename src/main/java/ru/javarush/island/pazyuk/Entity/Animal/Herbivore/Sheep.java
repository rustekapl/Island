package ru.javarush.island.pazyuk.Entity.Animal.Herbivore;

import ru.javarush.island.pazyuk.Entity.Plant.Grass;

import java.util.HashMap;

public class Sheep extends Herbivore {
    private static final double WEIGHT = 70.0d;
    private static final int MAX_COUNT = 140;
    private static final int SPEED = 3;
    private static final double HUNGER = 15.0d;

    public Sheep(int x, int y) {
        super(x, y, WEIGHT, MAX_COUNT, SPEED, HUNGER, new HashMap<>() {{
            put(Grass.class, 100);
        }});
    }
}
