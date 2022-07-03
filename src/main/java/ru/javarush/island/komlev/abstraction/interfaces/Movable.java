package ru.javarush.island.komlev.abstraction.interfaces;


import ru.javarush.island.komlev.etnity.map.Cell;

@FunctionalInterface
public interface Movable {
    Cell move(Cell startCell);
}
