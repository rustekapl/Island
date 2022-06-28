package ru.javarush.island.smulko.abstractions;

import ru.javarush.island.smulko.entity.map.Cell;

@FunctionalInterface
public interface Moveable {

    void move(Cell target);
}
