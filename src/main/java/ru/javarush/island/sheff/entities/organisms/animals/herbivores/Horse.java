package ru.javarush.island.sheff.entities.organisms.animals.herbivores;

import lombok.Getter;

@Getter
public class Horse extends Herbivore {

    public Horse(Horse other) {
        super(other);
    }

    @Override
    public Horse copy() {
        return new Horse(this);
    }
}
