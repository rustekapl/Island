package ru.javarush.island.zazimko.classes.animals.carnivores;

import ru.javarush.island.zazimko.classes.animals.herbivores.Duck;
import ru.javarush.island.zazimko.classes.animals.herbivores.Mouse;
import ru.javarush.island.zazimko.classes.animals.herbivores.Rabbit;

import java.lang.reflect.Type;
import java.util.concurrent.ConcurrentHashMap;

import static ru.javarush.island.zazimko.modificators.Config.*;

public class Snake extends Carnivore {
    ConcurrentHashMap<Type, Integer> initializedRation;

    public Snake() {
        this.setName("Snake " + this.getId());
        this.setIcon(SNAKE_ICON);
        this.setWeight(SNAKE_WEIGHT);
        this.setSpeed(SNAKE_SPEED);
        this.setSatiety(SNAKE_SATIETY);
        this.setMaxValueOfEntity(SNAKE_MAX_VALUE);
        this.setMaxWeight(SNAKE_WEIGHT);
        this.initializedRation = initializedRation();
    }

    private ConcurrentHashMap<Type, Integer> initializedRation() {
        ConcurrentHashMap<Type, Integer> eat = new ConcurrentHashMap<>();
        eat.put(Fox.class, 15);
        eat.put(Rabbit.class, 20);
        eat.put(Mouse.class, 40);
        eat.put(Duck.class, 10);
        return eat;
    }
}
