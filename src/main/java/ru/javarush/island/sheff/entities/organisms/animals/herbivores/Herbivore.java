package ru.javarush.island.sheff.entities.organisms.animals.herbivores;

import ru.javarush.island.sheff.entities.organisms.animals.Animal;

public abstract class Herbivore extends Animal {

    public Herbivore(Herbivore other) {
        super(other);
    }
}
