package ru.javarush.island.komlev.abstraction.interfaces;

import ru.javarush.island.komlev.etnity.map.Cell;

@FunctionalInterface
public interface Eating {
    void eat(Cell currentCell);

}
