package ru.javarush.island.sheff.entities.organisms.animals.herbivores;

import lombok.Getter;

@Getter
public class Boar extends Herbivore {

    public Boar(Boar other) {
        super(other);
    }

    @Override
    public Boar copy() {
        return new Boar(this);
    }
}
