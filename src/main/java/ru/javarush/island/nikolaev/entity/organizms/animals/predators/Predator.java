package ru.javarush.island.nikolaev.entity.organizms.animals.predators;

import ru.javarush.island.nikolaev.entity.organizms.Limit;
import ru.javarush.island.nikolaev.entity.organizms.animals.Animal;

public abstract class Predator extends Animal {


    public Predator(String name, String icon, double weight, int idFromTheSpecTable, Limit limit) {
        super(name, icon, weight, idFromTheSpecTable, limit);
    }


}
