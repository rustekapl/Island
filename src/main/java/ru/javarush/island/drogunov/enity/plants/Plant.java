package ru.javarush.island.drogunov.enity.plants;

import ru.javarush.island.drogunov.enity.GameUnit;
import ru.javarush.island.drogunov.interfaces.Vegetable;

public abstract class Plant extends GameUnit implements Vegetable {

    public Plant(int x, int y) {
        super(x, y);
    }
}
