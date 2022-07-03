package ru.javarush.island.nikolaev.entity.organizms.animals;

import ru.javarush.island.nikolaev.abstraction.entity.Eating;
import ru.javarush.island.nikolaev.abstraction.entity.Movable;
import ru.javarush.island.nikolaev.abstraction.entity.Reproducible;
import ru.javarush.island.nikolaev.entity.map.Cell;
import ru.javarush.island.nikolaev.entity.organizms.Limit;
import ru.javarush.island.nikolaev.entity.organizms.Organism;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;


public abstract class Animal
        extends Organism
        implements Eating, Reproducible, Movable {


    public Animal(String name, String icon, double weight, int idFromtheSpecTable, Limit limit) {
        super(name, icon, weight, idFromtheSpecTable, limit);
    }


    //TODO Починить еду и прикрепить рацион из таблицы в Config

    public boolean eat(Cell currentCell) {
        return true;
    }

    public void spawn(Cell cell) {
        safeSpawnAnimal(cell);
    }


    @Override
    public boolean move(Cell startCell) {
        int countStep = this.getLimit().getMaxSpeed();
        Cell destinationCell = startCell.getNextCell(countStep);
        return safeMove(startCell, destinationCell);
    }

    protected boolean safeMove(Cell source, Cell destination) {
        if (safeAddTo(destination)) { //if was added
            if (safePollFrom(source)) { //and after was extract
                return true; //ok
            } else {
                safePollFrom(destination); //die or eaten
            }
        }
        return false;
    }

    //TODO Починить еду и прикрепить рацион из таблицы в Config
    private boolean safeSpawnAnimal(Cell cell) {
        cell.getLock().lock();
        try {
            Set<Organism> organismSet = cell.getResidents().get(getType());
            double maxWeight = getLimit().getMaxWeight();
            if (getWeight() > maxWeight / 2 &&
                    organismSet.contains(this) &&
                    organismSet.size() >= 2 &&
                    organismSet.size() < getLimit().getMaxCount()
            ) {
                double childWeight = getWeight() / 2;
                setWeight(childWeight / 2);
                Organism clone = Organism.clone(this);
                clone.setWeight(childWeight);
                organismSet.add(clone);
                return true;
            } else {
                return false;
            }
        } finally {
            cell.getLock().unlock();
        }
    }

    private Cell findLastCell(Cell startCell, int countCellForStep) {
        Set<Cell> visitedCells = new HashSet<>();
        while (visitedCells.size() < countCellForStep) {
            var nextCells = startCell
                    .getNextCell()
                    .stream()
                    .filter(cell -> !visitedCells.contains(cell))
                    .toList();
            int countDirections = nextCells.size();
            if (countDirections > 0) {
                startCell = nextCells.get(ThreadLocalRandom.current().nextInt(countDirections));
                visitedCells.add(startCell);
            } else {
                break;
            }
        }
        return startCell;
    }


    private void safeModification(Cell cell, Consumer<Cell> operation) {
        cell.getLock().lock();
        try {
            operation.accept(cell);
        } finally {
            cell.getLock().unlock();
        }
    }

}
