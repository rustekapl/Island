package ru.javarush.island.zazimko.abstraction.entity;

import ru.javarush.island.zazimko.entity.map.Cell;

@FunctionalInterface
public interface Eating {

    boolean eat(Cell currentCell);

}
