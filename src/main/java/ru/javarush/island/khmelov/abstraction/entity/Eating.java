package ru.javarush.island.khmelov.abstraction.entity;

import ru.javarush.island.khmelov.entity.map.Cell;

@FunctionalInterface
public interface Eating {

    boolean eat(Cell currentCell);

}
