package ru.javarush.island.pazyuk.Entity.Animal.Carnivore;

import ru.javarush.island.pazyuk.Entity.Animal.Herbivore.*;

import java.util.HashMap;

public class Bear extends Carnivore {
    private static final double WEIGHT = 500.0d;
    private static final int MAX_COUNT = 5;
    private static final int SPEED = 2;
    private static final double HUNGER = 80.0d;

    public Bear(int x, int y) {
        //TODO Coding. Hard code. Not flexible
        super(x, y, WEIGHT, MAX_COUNT, SPEED, HUNGER, new HashMap<>() {{
            put(Boa.class, 80);
            put(Boar.class, 50);
            put(Buffalo.class, 20);
            put(Deer.class, 80);
            put(Duck.class, 10);
            put(Goat.class, 70);
            put(Horse.class, 40);
            put(Mouse.class, 90);
            put(Rabbit.class, 80);
            put(Sheep.class, 70);
        }});
    }
}
