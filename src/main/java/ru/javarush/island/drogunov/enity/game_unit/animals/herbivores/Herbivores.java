package ru.javarush.island.drogunov.enity.game_unit.animals.herbivores;

import ru.javarush.island.drogunov.enity.game_unit.Limits;
import ru.javarush.island.drogunov.enity.game_unit.animals.Animal;

public abstract class Herbivores extends Animal {

    public Herbivores(String name, String icon, Limits limits) {
        super(name, icon, limits);
    }
}
