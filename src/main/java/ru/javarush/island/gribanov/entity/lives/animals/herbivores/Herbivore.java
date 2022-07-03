package ru.javarush.island.gribanov.entity.lives.animals.herbivores;

import ru.javarush.island.gribanov.constants.Sex;
import ru.javarush.island.gribanov.entity.lives.Limit;
import ru.javarush.island.gribanov.entity.lives.animals.Animal;

public abstract class Herbivore extends Animal {
    public Herbivore(String name, String icon, double weight, Limit limit, Sex sex) {
        super(name, icon, weight, limit, sex);
    }
}
