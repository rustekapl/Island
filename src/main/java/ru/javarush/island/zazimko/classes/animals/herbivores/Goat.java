package ru.javarush.island.zazimko.classes.animals.herbivores;

import static ru.javarush.island.zazimko.modificators.Config.*;

public class Goat extends Herbivores {
    public Goat() {
        this.setName("Goat " + this.getId());
        this.setIcon(GOAT_ICON);
        this.setWeight(GOAT_WEIGHT);
        this.setSpeed(GOAT_SPEED);
        this.setSatiety(GOAT_SATIETY);
        this.setMaxValueOfEntity(GOAT_MAX_VALUE);
    }
}
