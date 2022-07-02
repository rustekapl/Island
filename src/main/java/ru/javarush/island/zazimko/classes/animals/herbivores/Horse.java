package ru.javarush.island.zazimko.classes.animals.herbivores;

import static ru.javarush.island.zazimko.modificators.Config.*;

public class Horse extends Herbivores {
    public Horse() {
        this.setName("Horse " + this.getId());
        this.setIcon(HORSE_ICON);
        this.setWeight(HORSE_WEIGHT);
        this.setSpeed(HORSE_SPEED);
        this.setSatiety(HORSE_SATIETY);
        this.setMaxValueOfEntity(HORSE_MAX_VALUE);
    }
}
