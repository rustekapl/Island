package ru.javarush.island.khryukin.entity.map;

import ru.javarush.island.khryukin.entity.organisms.Organism;
import ru.javarush.island.khryukin.utils.RandomValue;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cell {
    private final Map<String, Set<Organism>> residents;
    private List<Cell> nextCell;
    private final Lock lock = new ReentrantLock(true);

    public Lock getLock() {
        return lock;
    }

    public Cell(Map<String, Set<Organism>> residents) {
        this.residents = residents;
    }

    public Map<String, Set<Organism>> getResidents() {
        return residents;
    }

    public void setNextCell(List<Cell> nextCell) {
        this.nextCell = nextCell;
    }

    public List<Cell> getNextCell() {
        return nextCell;
    }
    public Cell getNextCells(int countStep) {
        Set<Cell> visitedCells = new HashSet<>();
        Cell currentCell = this;
        while (visitedCells.size() < countStep) {
            var nextCells = currentCell
                    .nextCell
                    .stream()
                    .filter(cell -> !visitedCells.contains(cell))
                    .toList();
            int countDirections = nextCells.size();
            if (countDirections > 0) {
                int index = RandomValue.random(0, countDirections);
                currentCell = nextCells.get(index);
                visitedCells.add(currentCell);
            } else {
                break;
            }
        }
        return currentCell;
    }
}
