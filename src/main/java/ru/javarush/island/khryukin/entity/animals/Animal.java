package ru.javarush.island.khryukin.entity.animals;

import ru.javarush.island.khryukin.actions.Movable;
import ru.javarush.island.khryukin.actions.Reproducible;
import ru.javarush.island.khryukin.entity.animals.organisms.Limit;
import ru.javarush.island.khryukin.entity.animals.organisms.Organism;
import ru.javarush.island.khryukin.entity.map.Cell;

import java.lang.reflect.Type;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;

public abstract class Animal extends Organism implements Movable, Reproducible {
    public Animal(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }

    @Override
    public Cell move(Cell startCell) {
        int countCellForStep = this.getLimit().getMaxSpeed();
        List<Cell> cel = startCell.getNextCell();
        Cell nextCell = cel.stream().findAny().get();

        removeMe(startCell);
        addMe(nextCell);
        return nextCell;

        /*int countCellForStep = this.getLimit().getMaxSpeed();
        Cell last = findLastCell(startCell, countCellForStep);
        removeMe(startCell);
        addMe(last);
        return last;*/
    }

    private Cell findLastCell(Cell startCell, int countCellForStep) {
        Cell newCell = new Cell(startCell.getResidents());
        Set<Cell> visitedCells = new HashSet<>();
        while (visitedCells.size() < countCellForStep) {
            var nextCells = startCell
                    .getNextCell()
                    .stream()
                    .filter(cell -> !visitedCells.contains(cell))
                    .toList();
            int countDirections = nextCells.size();
            if (countDirections > 0) {
                newCell = nextCells.get(ThreadLocalRandom.current().nextInt(countDirections));
                visitedCells.add(newCell);
            } else {
                break;
            }
        }
        return newCell;
    }

    private void addMe(Cell cell) {
        safeModification(cell, c -> c.getResidents().get(this.getClass()).add(this));
        //cell.getResidents().get(this.getClass()).add(this);
    }

    private void removeMe(Cell cell) {
        safeModification(cell, c -> c.getResidents().get(this.getClass()).remove(this));
        //cell.getResidents().get(this.getClass()).remove(this);
    }

    private void safeModification(Cell cell, Consumer<Cell> operation) {
        cell.getLock().lock();
        try {
            operation.accept(cell);
        } finally {
            cell.getLock().unlock();
        }
    }

    private void bornClone(Cell cell) {
        safeModification(cell, c -> c.getResidents().get(this.getClass()).add(this.clone()));
    }

    @Override
    public void spawn(Cell currentCell) {
        Type type = this.getClass();
        Map<Type, Set<Organism>> residents = currentCell.getResidents();
        Set<Organism> organisms = residents.get(type);
        if (Objects.nonNull(organisms) && organisms.contains(this) && organisms.size() > 2) {
            bornClone(currentCell);
        }
    }
}
