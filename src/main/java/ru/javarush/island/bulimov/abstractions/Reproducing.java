package ru.javarush.island.bulimov.abstractions;

import ru.javarush.island.bulimov.islandMap.Cell;
@FunctionalInterface
public interface Reproducing {
    boolean reproducing(Cell cell) throws InstantiationException, IllegalAccessException;
}
