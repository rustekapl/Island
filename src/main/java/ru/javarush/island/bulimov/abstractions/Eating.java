package ru.javarush.island.bulimov.abstractions;

import ru.javarush.island.bulimov.islandMap.Cell;

@FunctionalInterface
public interface Eating {
    boolean eating(Cell cell);
}
