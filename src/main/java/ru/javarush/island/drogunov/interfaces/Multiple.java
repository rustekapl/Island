package ru.javarush.island.drogunov.interfaces;

import ru.javarush.island.drogunov.enity.game_space.Cell;

@SuppressWarnings("ALL")
@FunctionalInterface
public interface Multiple {
    boolean multiply(Cell cell);
}
