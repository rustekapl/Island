package ru.javarush.island.zazimko.classes.animals.herbivores;

import static ru.javarush.island.zazimko.modificators.Config.*;

public class Buffalo extends Herbivores {
    public Buffalo() {
        this.setName("Buffalo " + this.getId());
        this.setIcon(BUFFALO_ICON);
        this.setWeight(BUFFALO_WEIGHT);
        this.setSpeed(BUFFALO_SPEED);
        this.setSatiety(BUFFALO_SATIETY);
        this.setMaxValueOfEntity(BUFFALO_MAX_VALUE);

    }
}
