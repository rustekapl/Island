package ru.javarush.island.sheff.entities.organisms.animals.herbivores;

import lombok.Getter;

@Getter
public class Buffalo extends Herbivore {

    public Buffalo(Buffalo other) {
        super(other);
    }

    @Override
    public Buffalo copy() {
        return new Buffalo(this);
    }
}
