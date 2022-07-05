package ru.javarush.island.gribanov.abstraction.entity;

import ru.javarush.island.gribanov.entity.map.Cell;

@FunctionalInterface
public interface Reproducible {
    void spawn(Cell currentCell);
}
