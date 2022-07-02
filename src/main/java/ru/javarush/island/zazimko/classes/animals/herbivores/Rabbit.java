package ru.javarush.island.zazimko.classes.animals.herbivores;

import static ru.javarush.island.zazimko.modificators.Config.*;

public class Rabbit extends Herbivores {
    public Rabbit() {
        this.setName("Rabbit " + this.getId());
        this.setIcon(RABBIT_ICON);
        this.setWeight(RABBIT_WEIGHT);
        this.setSpeed(RABBIT_SPEED);
        this.setSatiety(RABBIT_SATIETY);
        this.setMaxValueOfEntity(RABBIT_MAX_VALUE);
    }
}
