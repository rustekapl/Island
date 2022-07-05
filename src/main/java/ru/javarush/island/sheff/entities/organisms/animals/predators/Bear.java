package ru.javarush.island.sheff.entities.organisms.animals.predators;

import lombok.Getter;

@Getter
public class Bear extends Predator {

    public Bear(Bear other) {
        super(other);
    }

    @Override
    public Bear copy() {
        return new Bear(this);
    }
}
