package ru.javarush.island.gribanov.entity.lives.animals.herbivores;

import ru.javarush.island.gribanov.constants.Sex;
import ru.javarush.island.gribanov.entity.lives.Limit;

public class Rabbit extends Herbivore{
    public Rabbit(String name, String icon, double weight, Limit limit, Sex sex) {
        super(name, icon, weight, limit, sex);
    }
}
