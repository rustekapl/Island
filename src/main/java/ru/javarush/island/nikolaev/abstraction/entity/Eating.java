package ru.javarush.island.nikolaev.abstraction.entity;

import ru.javarush.island.nikolaev.entity.map.Cell;

@FunctionalInterface
public interface Eating {

    boolean eat(Cell currentCell);

}