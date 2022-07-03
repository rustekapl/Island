package ru.javarush.island.gribanov.entity.map;

import ru.javarush.island.gribanov.entity.lives.Organism;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cell {
    private final int COLUMN;
    private final int ROW;

    private final Lock lock = new ReentrantLock(true);

    public Lock getLock() {
        return lock;
    }

    private final Map<String, Set<Organism>> residents;
    private final List<Cell> neighboringCells = new ArrayList<>();

    public Cell(int column, int ROW, Map<String, Set<Organism>> residents) {
        this.COLUMN = column;
        this.ROW = ROW;
        this.residents = residents;
    }

    public Map<String, Set<Organism>> getResidents() {
        return residents;
    }

    public void updateNeighbors(GameMap gameMap){
        Cell[][] mapCells = gameMap.getCells();
        Cell cellToAdd;
        for (int i = ROW - 1; i <= ROW + 1; i++) {
            for (int j = COLUMN - 1; j <= COLUMN + 1; j++) {
                if (i >= 0 && j >= 0 && i < gameMap.HEIGHT && j < gameMap.WIDTH){
                    cellToAdd = mapCells[i][j];
                    if (!this.equals(cellToAdd)) {
                        neighboringCells.add(cellToAdd);
                    }
                }
            }
        }
    }

    public List<Cell> getNeighboringCells() {
        return neighboringCells;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return COLUMN == cell.COLUMN && ROW == cell.ROW && Objects.equals(lock, cell.lock) && Objects.equals(residents, cell.residents) && Objects.equals(neighboringCells, cell.neighboringCells);
    }

    @Override
    public int hashCode() {
        return Objects.hash(COLUMN, ROW, lock, residents, neighboringCells);
    }
}
