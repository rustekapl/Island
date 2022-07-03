package ru.javarush.island.sheff.entities.organisms.animals.predators;

import lombok.Getter;

@Getter
public class Fox extends Predator{

    public Fox(Fox other) {
        super(other);
    }

    @Override
    public Fox copy() {
        return new Fox(this);
    }
}
