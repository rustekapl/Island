package ru.javarush.island.sheff.entities.organisms.animals.predators;

import lombok.Getter;

@Getter
public class Boa extends Predator{

    public Boa(Boa other) {
        super(other);
    }

    @Override
    public Boa copy() {
        return new Boa(this);
    }
}
