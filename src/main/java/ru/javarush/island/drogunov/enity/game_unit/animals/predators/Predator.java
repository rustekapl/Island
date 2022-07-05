package ru.javarush.island.drogunov.enity.game_unit.animals.predators;

import ru.javarush.island.drogunov.enity.game_unit.Limits;
import ru.javarush.island.drogunov.enity.game_unit.animals.Animal;

public abstract class Predator extends Animal {
    public Predator(String name, String icon, Limits limits) {
        super(name, icon, limits);
    }
}
