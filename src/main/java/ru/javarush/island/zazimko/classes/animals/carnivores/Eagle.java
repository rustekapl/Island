package ru.javarush.island.zazimko.classes.animals.carnivores;

import ru.javarush.island.zazimko.classes.animals.herbivores.Duck;
import ru.javarush.island.zazimko.classes.animals.herbivores.Mouse;
import ru.javarush.island.zazimko.classes.animals.herbivores.Rabbit;

import java.lang.reflect.Type;
import java.util.concurrent.ConcurrentHashMap;

import static ru.javarush.island.zazimko.modificators.Config.*;

public class Eagle extends Carnivore {
    //TODO ---  initializedRation ?????
    ConcurrentHashMap<Type, Integer> initializedRation;

    public Eagle() {
        this.setName("Eagle " + this.getId());
        this.setIcon(EAGLE_ICON);
        this.setWeight(EAGLE_WEIGHT);
        this.setSpeed(EAGLE_SPEED);
        this.setSatiety(EAGLE_SATIETY);
        this.setMaxValueOfEntity(EAGLE_MAX_VALUE);
        this.setMaxWeight(EAGLE_WEIGHT);
        this.initializedRation = initializedRation();
    }

    private ConcurrentHashMap<Type, Integer> initializedRation() {
        ConcurrentHashMap<Type, Integer> eat = new ConcurrentHashMap<>();
        eat.put(Fox.class, 10);
        eat.put(Rabbit.class, 90);
        eat.put(Mouse.class, 90);
        eat.put(Duck.class, 80);
        return eat;
    }
}
