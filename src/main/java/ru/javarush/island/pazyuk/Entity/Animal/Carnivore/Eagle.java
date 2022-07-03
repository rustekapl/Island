package ru.javarush.island.pazyuk.Entity.Animal.Carnivore;

import ru.javarush.island.pazyuk.Entity.Animal.Herbivore.Duck;
import ru.javarush.island.pazyuk.Entity.Animal.Herbivore.Mouse;
import ru.javarush.island.pazyuk.Entity.Animal.Herbivore.Rabbit;

import java.util.HashMap;

public class Eagle extends Carnivore {
    private static final double WEIGHT = 6.0d;
    private static final int MAX_COUNT = 20;
    private static final int SPEED = 3;
    private static final double HUNGER = 1.0d;

    public Eagle(int x, int y) {
        super(x, y, WEIGHT, MAX_COUNT, SPEED, HUNGER, new HashMap<>() {{
            put(Fox.class, 10);

            put(Duck.class, 80);
            put(Mouse.class, 90);
            put(Rabbit.class, 90);
        }});
    }
}
