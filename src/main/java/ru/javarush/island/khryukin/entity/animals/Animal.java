package ru.javarush.island.khryukin.entity.animals;

import ru.javarush.island.khryukin.actions.Movable;
import ru.javarush.island.khryukin.actions.Reproducible;
import ru.javarush.island.khryukin.entity.organisms.Limit;
import ru.javarush.island.khryukin.entity.organisms.Organism;
import ru.javarush.island.khryukin.entity.map.Cell;

import java.util.*;
import java.util.function.Consumer;

public abstract class Animal extends Organism implements Movable, Reproducible {
    public Animal(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }

    @Override
    public Cell move(Cell startCell) {
        int countStep = this.getLimit().getMaxSpeed();
        Cell destinationCell = startCell.getNextCells(countStep);
        removeMe(startCell);
        addMe(destinationCell);
        return destinationCell;

    }

    /*private Cell findLastCell(Cell startCell, int countCellForStep) {
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
    }*/
    //TODO cell capacity test
    private void addMe(Cell cell) {
        cell.getLock().lock();
        try {
            Set<Organism> set = cell.getResidents().get(getType());
            if (Objects.nonNull(set)) {
                int maxCount = getLimit().getMaxCount();
                set.add(this);
            } else {
                Map<String, Set<Organism>> residents = cell.getResidents();
                residents.put(this.getType(), new HashSet<>());
                Set<Organism> organisms = residents.get(getType());
                organisms.add(this);
            }

        } finally {
            cell.getLock().unlock();
        }
    }

    private void removeMe(Cell cell) {
        cell.getLock().lock();
        try {
            cell.getResidents().get(getType()).remove(this);
        } finally {
            cell.getLock().unlock();
        }
    }

    private void safeModification(Cell cell, Consumer<Cell> operation) {
        cell.getLock().lock();
        try {
            operation.accept(cell);
        } finally {
            cell.getLock().unlock();
        }
    }

    @Override
    public void spawn(Cell currentCell) {
        /*Set<Organism> organisms = currentCell.getResidents().get(this.getType());
        if (Objects.nonNull(organisms) && organisms.contains(this) && organisms.size() > 2) {
            //bornClone(currentCell);
            safeSpawnAnimal(currentCell);
        }*/
        safeSpawnAnimal3(currentCell);
    }

    private void safeSpawnAnimal(Cell currentCell) {
        currentCell.getLock().lock();
        try {
            Set<Organism> organisms = currentCell.getResidents().get(getType());
            double maxWeight = getLimit().getMaxWeight();
            if (/*this.getWeight() > maxWeight / 2 &&*/
                    organisms.contains(this) &&
                    organisms.size() >= 2 &&
                    organisms.size() < getLimit().getMaxCount()) {
                double childWeight = getLimit().getMaxWeight() / 4;
                //this.setWeight(this.getWeight() - childWeight);
                Organism clone = this.clone();
                //clone.setWeight(childWeight);
                organisms.add(clone);
            }
        } finally {
            currentCell.getLock().unlock();
        }
    }
    private void safeSpawnAnimal2(Cell currentCell) {
        currentCell.getLock().lock();
        try {
            Set<Organism> organisms = currentCell.getResidents().get(getType());
            double maxWeight = getLimit().getMaxWeight();
            if(Objects.nonNull(organisms)){
                if (this.getWeight() > maxWeight / 2 && organisms.size() >= 2 && organisms.size() < getLimit().getMaxCount()) {
                    double childWeight = getLimit().getMaxWeight() / 4;
                    this.setWeight(this.getWeight() - childWeight);
                    Organism clone = this.clone();
                    clone.setWeight(childWeight);
                    organisms.add(clone);
                }
            } /*else {
                Map<String, Set<Organism>> residents = currentCell.getResidents();
                residents.put(this.getType(), new HashSet<>());
                Set<Organism> organism = residents.get(getType());
                organism.add(this);
            }*/
        } finally {
            currentCell.getLock().unlock();
        }
    }
    private void safeSpawnAnimal3(Cell currentCell) {
        currentCell.getLock().lock();
        try {
            Set<Organism> organisms = currentCell.getResidents().get(getType());
            //double maxWeight = this.getLimit().getMaxWeight();
            if(Objects.nonNull(organisms)){
                if (organisms.size() < getLimit().getMaxCount()) {
                    Organism clone = this.clone();
                    clone.setWeight(getLimit().getMaxWeight());
                    organisms.add(clone);
                }
            }
        } finally {
            currentCell.getLock().unlock();
        }
    }
}
