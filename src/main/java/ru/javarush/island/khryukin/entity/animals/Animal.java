package ru.javarush.island.khryukin.entity.animals;

import ru.javarush.island.khryukin.actions.Eating;
import ru.javarush.island.khryukin.actions.Movable;
import ru.javarush.island.khryukin.actions.Reproducible;
import ru.javarush.island.khryukin.entity.organisms.Limit;
import ru.javarush.island.khryukin.entity.organisms.Organism;
import ru.javarush.island.khryukin.entity.map.Cell;
import ru.javarush.island.khryukin.property.Setting;
import ru.javarush.island.khryukin.utils.RandomValue;

import java.util.*;
import java.util.function.Consumer;

public abstract class Animal extends Organism implements Movable, Reproducible, Eating {
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

    @Override
    public void spawn(Cell currentCell) {
        safeSpawnAnimal4(currentCell);
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
            }
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
                if (organisms.size() < getLimit().getMaxCount() &&
                        organisms.size() >= 2 &&
                        this.getWeight() > this.getLimit().getMaxWeight() / 2) {
                    Organism clone = this.clone();
                    clone.setWeight(getLimit().getMaxWeight());
                    organisms.add(clone);
                }
            }
        } finally {
            currentCell.getLock().unlock();
        }
    }
    private void safeSpawnAnimal4(Cell currentCell) {
        currentCell.getLock().lock();
        try {
            Set<Organism> organisms = currentCell.getResidents().get(getType());
            double maxWeight = getLimit().getMaxWeight();
            if (this.getWeight() > maxWeight / 2 &&
                    organisms.contains(this) &&
                            organisms.size() >= 2 &&
                            organisms.size() < getLimit().getMaxCount()) {
                double childWeight = getLimit().getMaxWeight() / 2;
                this.setWeight(this.getWeight() - childWeight);
                Organism clone = this.clone();
                clone.setWeight(childWeight);
                organisms.add(clone);
            }
        } finally {
            currentCell.getLock().unlock();
        }
    }

    @Override
    public void eat(Cell currentCell) {
        if (safeFindFood(currentCell)) {
        } else if (getWeight() > 0) {
            safeChangeWeight(currentCell, -5);
        } else {
            safeDie(currentCell);
        }
    }

    protected boolean safeFindFood(Cell currentCell) {
        currentCell.getLock().lock();
        try {
            double needFood = getNeedFood();
            if (!(needFood <= 0)) {
                var foodMap = Setting.rationMap.get(getType())
                        .entrySet();
                var iterator = foodMap.iterator();
                while (needFood > 0 && iterator.hasNext()) {
                    Map.Entry<String, Integer> entry = iterator.next();
                    String keyFood = entry.getKey();
                    Integer probably = entry.getValue();
                    var foods = currentCell.getResidents().get(keyFood);
                    if(Objects.nonNull(foods)) {
                        if (foods.size() > 0 && probably > RandomValue.random(0, 100)) {
                            for (Iterator<Organism> organismIterator = foods.iterator(); organismIterator.hasNext(); ) {
                                Organism o = organismIterator.next();
                                double foodWeight = o.getWeight();
                                double delta = Math.min(foodWeight, needFood);
                                double weight = getWeight();
                                setWeight(Math.min(weight + delta, getLimit().getMaxWeight()));
                                o.setWeight(0);
                                //o.setWeight(foodWeight - delta);
                                if (o.getWeight() <= 0) {
                                    organismIterator.remove();
                                }
                                needFood -= delta;
                                if (needFood <= 0) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            } else {
                return false;
            }
        } finally {
            currentCell.getLock().unlock();
        }
        return false;
    }

    private double getNeedFood() {
        return Math.min(
                getLimit().getMaxFood(),
                getLimit().getMaxWeight() - getWeight());
    }

    protected void safeChangeWeight(Cell currentCell, int percent) {
        currentCell.getLock().lock();
        double weight = this.getWeight();
        try {
            double maxWeight = getLimit().getMaxWeight();
            weight += maxWeight * percent / 100;
            weight = Math.max(0, weight);
            this.setWeight(Math.min(weight, maxWeight));
            currentCell.getResidents().get(this.getClass().getSimpleName());
        } finally {
            currentCell.getLock().unlock();
        }
    }
}
