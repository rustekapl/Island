package ru.javarush.island.ryabov.interfaces;

import ru.javarush.island.ryabov.entity.map.Cell;
import ru.javarush.island.ryabov.entity.organisms.types.Organism;

@SuppressWarnings("unused")
public interface Movable {
    default void move(Cell cell, Cell nextCell) {
        cell.ORGANISMS.remove(this);
        nextCell.ORGANISMS.add((Organism) this);
    }
}
