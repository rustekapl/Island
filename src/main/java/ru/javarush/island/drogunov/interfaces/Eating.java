package ru.javarush.island.drogunov.interfaces;

import ru.javarush.island.drogunov.enity.game_unit.GameUnit;

@FunctionalInterface
public interface Eating {
    @SuppressWarnings("unused")
    void eat(GameUnit gameUnit);
}
