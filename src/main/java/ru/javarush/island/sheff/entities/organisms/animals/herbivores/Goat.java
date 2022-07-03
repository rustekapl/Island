package ru.javarush.island.sheff.entities.organisms.animals.herbivores;

import lombok.Getter;

@Getter
public class Goat extends Herbivore {

    public Goat(Goat other) {
        super(other);
    }

    @Override
    public Goat copy() {
        return new Goat(this);
    }
}
