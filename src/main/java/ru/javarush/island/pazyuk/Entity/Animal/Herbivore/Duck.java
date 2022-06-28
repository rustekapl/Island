package ru.javarush.island.pazyuk.Entity.Animal.Herbivore;

import ru.javarush.island.pazyuk.Entity.Plant.Grass;

import java.util.HashMap;

public class Duck extends Herbivore {
    private static final double WEIGHT = 1.0d;
    private static final int MAX_COUNT = 200;
    private static final int SPEED = 4;
    private static final double HUNGER = 0.15d;

    public Duck(int x, int y) {
        super(x, y, WEIGHT, MAX_COUNT, SPEED, HUNGER, new HashMap<>() {{
            put(Caterpillar.class, 90);

            put(Grass.class, 100);
        }});
    }
}
