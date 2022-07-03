package ru.javarush.island.pazyuk.Entity.Animal.Herbivore;

import ru.javarush.island.pazyuk.Entity.Plant.Grass;

import java.util.HashMap;

public class Mouse extends Herbivore {
    private static final double WEIGHT = 0.05d;
    private static final int MAX_COUNT = 500;
    private static final int SPEED = 1;
    private static final double HUNGER = 0.01d;

    public Mouse(int x, int y) {
        super(x, y, WEIGHT, MAX_COUNT, SPEED, HUNGER, new HashMap<>() {{
            put(Caterpillar.class, 90);

            put(Grass.class, 100);
        }});
    }
}
