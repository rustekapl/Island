package ru.javarush.island.zazimko.abstraction.entity;

import ru.javarush.island.zazimko.entity.map.Cell;

@FunctionalInterface
public interface Reproducible {

    @SuppressWarnings("UnusedReturnValue")
    boolean spawn(Cell currentCell);

}
