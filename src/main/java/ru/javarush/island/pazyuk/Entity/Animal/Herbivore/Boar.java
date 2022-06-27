package ru.javarush.island.pazyuk.Entity.Animal.Herbivore;

import ru.javarush.island.pazyuk.Entity.Plant.Grass;

import java.util.HashMap;

public class Boar extends Herbivore {
    private static final double WEIGHT = 400.0d;
    private static final int MAX_COUNT = 50;
    private static final int SPEED = 2;
    private static final double HUNGER = 50.0d;

    public Boar(int x, int y) {
        super(x, y, WEIGHT, MAX_COUNT, SPEED, HUNGER, new HashMap<>() {{
            put(Caterpillar.class, 90);
            put(Mouse.class, 50);

            put(Grass.class, 100);
        }});
    }
}
