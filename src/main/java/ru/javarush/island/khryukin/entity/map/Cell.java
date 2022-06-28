package ru.javarush.island.khryukin.entity.map;

import ru.javarush.island.khryukin.entity.animals.organisms.Organism;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cell {
    private final Map<Type, Set<Organism>> residents;
    private List<Cell> nextCell;
    private final Lock lock = new ReentrantLock(true);

    public Lock getLock() {
        return lock;
    }

    public Cell(Map<Type, Set<Organism>> residents) {
        this.residents = residents;
    }

    public Map<Type, Set<Organism>> getResidents() {
        return residents;
    }

    public void setNextCell(List<Cell> nextCell) {
        this.nextCell = nextCell;
    }

    public List<Cell> getNextCell() {
        return nextCell;
    }
}
