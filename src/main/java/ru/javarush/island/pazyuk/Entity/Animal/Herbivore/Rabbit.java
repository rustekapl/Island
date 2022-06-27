package ru.javarush.island.pazyuk.Entity.Animal.Herbivore;

import ru.javarush.island.pazyuk.Entity.Plant.Grass;

import java.util.HashMap;

public class Rabbit extends Herbivore {
    private static final double WEIGHT = 2.0d;
    private static final int MAX_COUNT = 150;
    private static final int SPEED = 2;
    private static final double HUNGER = 0.45d;

    public Rabbit(int x, int y) {
        super(x, y, WEIGHT, MAX_COUNT, SPEED, HUNGER, new HashMap<>() {{
            put(Grass.class, 100);
        }});
    }
}
