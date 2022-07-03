package ru.javarush.island.zazimko.classes.animals.herbivores;

import static ru.javarush.island.zazimko.modificators.Config.*;

public class Mouse extends Herbivores {
    public Mouse() {
        this.setName("Mouse " + this.getId());
        this.setIcon(MOUSE_ICON);
        this.setWeight(MOUSE_WEIGHT);
        this.setSpeed(MOUSE_SPEED);
        this.setSatiety(MOUSE_SATIETY);
        this.setMaxValueOfEntity(MOUSE_MAX_VALUE);
    }
}
