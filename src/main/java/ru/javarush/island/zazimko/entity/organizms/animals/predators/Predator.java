package ru.javarush.island.zazimko.entity.organizms.animals.predators;


import ru.javarush.island.zazimko.entity.organizms.Limit;
import ru.javarush.island.zazimko.entity.organizms.animals.Animal;

public abstract class Predator extends Animal {


    public Predator(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }


}
