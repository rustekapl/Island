package ru.javarush.island.pazyuk.Entity.Animal.Carnivore;

import ru.javarush.island.pazyuk.Entity.Animal.Animal;
import ru.javarush.island.pazyuk.Entity.Entity;

import java.util.HashMap;

public abstract class Carnivore extends Animal {
    public Carnivore(int x, int y, double weight, int maxCount, int speed, double hunger, HashMap<Class<? extends Entity>, Integer> chanceToEat) {
        super(x, y, weight, maxCount, speed, hunger, chanceToEat);
    }
}
