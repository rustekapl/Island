package ru.javarush.island.sheff.entities.organisms.animals.herbivores;

import lombok.Getter;

@Getter
public class Rabbit extends Herbivore {

    public Rabbit(Rabbit other) {
        super(other);
    }

    @Override
    public Rabbit copy() {
        return new Rabbit(this);
    }
}
