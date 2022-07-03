package ru.javarush.island.khryukin.actions;

import ru.javarush.island.khryukin.entity.map.Cell;

@FunctionalInterface
public interface Reproducible {
    void spawn(Cell currentCell);
}
