package ru.javarush.island.gribanov.entity.lives.animals.predators;

import ru.javarush.island.gribanov.constants.Sex;
import ru.javarush.island.gribanov.entity.lives.Limit;

public class Bear extends Predator{
    public Bear(String name, String icon, double weight, Limit limit, Sex sex) {
        super(name, icon, weight, limit, sex);
    }
}
