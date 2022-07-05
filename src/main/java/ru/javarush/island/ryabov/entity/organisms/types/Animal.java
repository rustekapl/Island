package ru.javarush.island.ryabov.entity.organisms.types;

import ru.javarush.island.ryabov.entity.organisms.Limit;
import ru.javarush.island.ryabov.interfaces.Eating;
import ru.javarush.island.ryabov.interfaces.Movable;
import ru.javarush.island.ryabov.interfaces.Reproducible;

public abstract class Animal extends Organism implements Movable, Reproducible, Eating {
    public Animal(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }
}
