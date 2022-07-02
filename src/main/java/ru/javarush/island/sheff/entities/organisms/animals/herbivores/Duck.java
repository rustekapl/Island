package ru.javarush.island.sheff.entities.organisms.animals.herbivores;

import lombok.Getter;

@Getter
public class Duck extends Herbivore {

    public Duck(Duck other) {
        super(other);
    }

    @Override
    public Duck copy() {
        return new Duck(this);
    }
}
