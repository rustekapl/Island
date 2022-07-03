package ru.javarush.island.sheff.entities.organisms.animals.predators;

import lombok.Getter;

@Getter
public class Wolf extends Predator{

    public Wolf(Wolf other) {
        super(other);
    }

    @Override
    public Wolf copy() {
        return new Wolf(this);
    }
}
