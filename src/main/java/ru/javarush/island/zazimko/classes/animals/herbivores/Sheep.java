package ru.javarush.island.zazimko.classes.animals.herbivores;

import static ru.javarush.island.zazimko.modificators.Config.*;

public class Sheep extends Herbivores {
    public Sheep() {
        this.setName("Sheep " + this.getId());
        this.setIcon(SHEEP_ICON);
        this.setWeight(SHEEP_WEIGHT);
        this.setSpeed(SHEEP_SPEED);
        this.setSatiety(SHEEP_SATIETY);
        this.setMaxValueOfEntity(SHEEP_MAX_VALUE);
    }
}
