package ru.javarush.island.khmelov.abstraction.entity;

import ru.javarush.island.khmelov.entity.map.Cell;

@FunctionalInterface
public interface Movable {

    @SuppressWarnings("UnusedReturnValue")
    boolean move(Cell startCell);

}
