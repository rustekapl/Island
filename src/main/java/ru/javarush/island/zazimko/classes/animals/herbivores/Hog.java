package ru.javarush.island.zazimko.classes.animals.herbivores;

import static ru.javarush.island.zazimko.modificators.Config.*;

public class Hog extends Herbivores {
    public Hog() {
        this.setName("Hog " + this.getId());
        this.setIcon(HOG_ICON);
        this.setWeight(HOG_WEIGHT);
        this.setSpeed(HOG_SPEED);
        this.setSatiety(HOG_SATIETY);
        this.setMaxValueOfEntity(HOG_MAX_VALUE);
    }
}
