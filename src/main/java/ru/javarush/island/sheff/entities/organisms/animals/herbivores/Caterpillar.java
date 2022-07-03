package ru.javarush.island.sheff.entities.organisms.animals.herbivores;

import lombok.Getter;

@Getter
public class Caterpillar extends Herbivore {

    public Caterpillar(Caterpillar other) {
        super(other);
    }

    @Override
    public Caterpillar copy() {
        return new Caterpillar(this);
    }
}
