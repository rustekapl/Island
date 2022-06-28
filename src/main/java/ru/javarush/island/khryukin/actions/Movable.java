package ru.javarush.island.khryukin.actions;

import ru.javarush.island.khryukin.entity.map.Cell;

public interface Movable {
    Cell move(Cell startCell);
}
