package ru.javarush.island.sheff.entities.organisms.animals.herbivores;

import lombok.Getter;

@Getter
public class Mouse extends Herbivore {

    public Mouse(Mouse other) {
        super(other);
    }

    @Override
    public Mouse copy() {
        return new Mouse(this);
    }
}
