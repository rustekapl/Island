package ru.javarush.island.sheff.entities.organisms.animals.herbivores;

import lombok.Getter;

@Getter
public class Sheep extends Herbivore {

    public Sheep(Sheep other) {
        super(other);
    }

    @Override
    public Sheep copy() {
        return new Sheep(this);
    }
}
