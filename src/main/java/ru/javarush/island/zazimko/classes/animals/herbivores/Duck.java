package ru.javarush.island.zazimko.classes.animals.herbivores;

import ru.javarush.island.zazimko.gameField.Cell;

import static ru.javarush.island.zazimko.modificators.Config.*;

public class Duck extends Herbivores {
    @Override
    public void toEat(Cell cell) {
    }

    public Duck() {
        this.setName("Duck " + this.getId());
        this.setIcon(DUCK_ICON);
        this.setWeight(DUCK_WEIGHT);
        this.setSpeed(DUCK_SPEED);
        this.setSatiety(DUCK_SATIETY);
        this.setMaxValueOfEntity(DUCK_MAX_VALUE);

    }
}
