package ru.javarush.island.sheff.entities.organisms.animals.herbivores;

import lombok.Getter;

@Getter
public class Deer extends Herbivore {

    public Deer(Deer other) {
        super(other);
    }

    @Override
    public Deer copy() {
        return new Deer(this);
    }
}
