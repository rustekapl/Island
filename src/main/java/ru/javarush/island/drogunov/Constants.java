package ru.javarush.island.drogunov;

import ru.javarush.island.drogunov.enity.animals.herbivors.*;
import ru.javarush.island.drogunov.enity.animals.predators.*;
import ru.javarush.island.drogunov.enity.plants.view_plants.SimplePlant;

import java.util.HashSet;
import java.util.Set;

public class Constants {

    public static final Set<Object> OBJECTS = new HashSet<>();

    static {
        OBJECTS.add(Wolf.class);
        OBJECTS.add(Boa.class);
        OBJECTS.add(Fox.class);
        OBJECTS.add(Bear.class);
        OBJECTS.add(Eagle.class);
        OBJECTS.add(Horse.class);
        OBJECTS.add(Deer.class);
        OBJECTS.add(Rabbit.class);
        OBJECTS.add(Mouse.class);
        OBJECTS.add(Goat.class);
        OBJECTS.add(Sheep.class);
        OBJECTS.add(WildBoard.class);
        OBJECTS.add(Buffalo.class);
        OBJECTS.add(Duck.class);
        OBJECTS.add(Caterpillar.class);
        OBJECTS.add(SimplePlant.class);
    }
}
