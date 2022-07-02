package ru.javarush.island.sheff.entities.organisms.animals.predators;

import ru.javarush.island.sheff.entities.organisms.animals.Animal;

public abstract class Predator extends Animal {

    public Predator(Predator other) {
        super(other);
    }
}
