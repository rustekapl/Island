package ru.javarush.island.sheff.entities.organisms.animals.predators;

import lombok.Getter;

@Getter
public class Eagle extends Predator {

    public Eagle(Eagle other) {
        super(other);
    }

    @Override
    public Eagle copy() {
        return new Eagle(this);
    }
}
