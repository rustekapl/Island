package ru.javarush.island.pazyuk.Entity.Animal.Carnivore;

import ru.javarush.island.pazyuk.Entity.Animal.Herbivore.*;

import java.util.HashMap;

public class Wolf extends Carnivore {
    private static final double WEIGHT = 50.0d;
    private static final int MAX_COUNT = 30;
    private static final int SPEED = 3;
    private static final double HUNGER = 8.0d;

    public Wolf(int x, int y) {
        super(x, y, WEIGHT, MAX_COUNT, SPEED, HUNGER, new HashMap<>() {{
            put(Boar.class, 15);
            put(Buffalo.class, 10);
            put(Deer.class, 15);
            put(Duck.class, 40);
            put(Goat.class, 60);
            put(Horse.class, 10);
            put(Mouse.class, 80);
            put(Rabbit.class, 60);
            put(Sheep.class, 70);
        }});
    }
}
