package ru.javarush.island.zazimko.classes.animals.herbivores;

import static ru.javarush.island.zazimko.modificators.Config.*;

public class Caterpillar extends Herbivores {
    public Caterpillar() {
        this.setName("Caterpillar " + this.getId());
        this.setIcon(CATERPILLAR_ICON);
        this.setWeight(CATERPILLAR_WEIGHT);
        this.setSpeed(CATERPILLAR_SPEED);
        this.setSatiety(CATERPILLAR_SATIETY);
        this.setMaxValueOfEntity(CATERPILLAR_MAX_VALUE);
    }
}
