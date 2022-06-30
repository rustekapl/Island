package ru.javarush.island.zazimko.classes.animals.carnivores;

import ru.javarush.island.zazimko.classes.animals.herbivores.*;

import java.lang.reflect.Type;
import java.util.concurrent.ConcurrentHashMap;

import static ru.javarush.island.zazimko.modificators.Config.*;

public class Wolf extends Carnivore {
    ConcurrentHashMap<Type, Integer> initializedRation;

    public Wolf() {
        this.setName("Wolf " + this.getId());
        this.setIcon(WOLF_ICON);
        this.setWeight(WOLF_WEIGHT);
        this.setSpeed(WOLF_SPEED);
        this.setSatiety(WOLF_SATIETY);
        this.setMaxValueOfEntity(WOLF_MAX_VALUE);
        this.setMaxWeight(WOLF_WEIGHT);
        this.initializedRation = initializedRation();
    }

    private ConcurrentHashMap<Type, Integer> initializedRation() {
        ConcurrentHashMap<Type, Integer> eat = new ConcurrentHashMap<>();
        eat.put(Horse.class, 10);
        eat.put(Deer.class, 15);
        eat.put(Rabbit.class, 60);
        eat.put(Mouse.class, 80);
        eat.put(Goat.class, 60);
        eat.put(Sheep.class, 70);
        eat.put(Hog.class, 15);
        eat.put(Buffalo.class, 10);
        eat.put(Duck.class, 40);
        return eat;
    }
}
