package ru.javarush.island.bulimov.islandMap;

import ru.javarush.island.bulimov.entity.Organism;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cell {
    public int column;
    public int line;

    private final Lock lock = new ReentrantLock(true);

    private final Map<String, Set<Organism>> animalsCell = new ConcurrentHashMap<>();

    public Map<String, Set<Organism>> getAnimalsCell() {
        return animalsCell;
    }

    public Lock getLock() {
        return lock;
    }

    public Cell(int column, int line) {
        this.column = column;
        this.line = line;
    }

}
