package ru.javarush.island.gribanov.entity.lives.animals;

import ru.javarush.island.gribanov.abstraction.entity.Eatable;
import ru.javarush.island.gribanov.abstraction.entity.Movable;
import ru.javarush.island.gribanov.constants.Sex;
import ru.javarush.island.gribanov.entity.lives.Limit;
import ru.javarush.island.gribanov.entity.lives.Organism;
import ru.javarush.island.gribanov.entity.map.Cell;
import ru.javarush.island.gribanov.exception.IslandException;
import ru.javarush.island.gribanov.utils.Configuration;
import ru.javarush.island.gribanov.utils.RandomGenerator;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class Animal extends Organism implements Eatable, Movable {

    private Sex sex;
    public Animal(String name, String icon, double weight, Limit limit, Sex sex) {

        super(name, icon, weight, limit);
        this.sex = sex;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public boolean eat(Cell currentCell) {
        currentCell.getLock().lock();
        try {
            double needToEat = getWeightToEat();
            if (!(needToEat <= 0)) {
                Configuration config = Configuration.get();
                Map<String, Integer> foodMap = config.getFoodMap(getType());
                Set<String> residents = currentCell.getResidents().keySet();
                Set<String> existingFoodTypes = new HashSet<>(foodMap.keySet());
                existingFoodTypes.retainAll(residents);

                for (String foodType : existingFoodTypes) {
                    int probably = foodMap.get(foodType);
                    Set<Organism> foods = currentCell
                            .getResidents()
                            .get(foodType);
                    if (foods.size() > 0 && RandomGenerator.get(probably)){
                        Organism food = foods
                                .iterator()
                                .next();
                        double weight = getWeight();
                        double foodWeight = food.getWeight();
                        double weightToEat = Math.min(foodWeight, needToEat);

                        setWeight(weight + weightToEat);
                        food.setWeight(food.getWeight() - weightToEat);
                        if (!food.isALive()){
                            foods.remove(food);
                        }
                        return true;
                    }
                }
                return false;
            }
            return false;
        } finally {
            currentCell.getLock().unlock();
        }
    }



    @Override
    public void move(Cell startCell) {
        int speed = LIMIT.getSPEED();
        if (speed > 0) {
            int stepsCount = RandomGenerator.random(0, speed);
            Cell previousCell = startCell;
            Cell destinationCell = null;
            int maxCountOnCell = LIMIT.getCOUNT_ON_CELL();
            for (int i = 0; i < stepsCount; i++) {
                List<Cell> neighborCells = previousCell.getNeighboringCells();
                if (neighborCells.size() == 1){
                    destinationCell = neighborCells.get (0);
                } else if (neighborCells.size() > 0) {
                    destinationCell = neighborCells.get(RandomGenerator.random(0, neighborCells.size() - 1));
                }
                if (destinationCell != null && destinationCell.getResidents().get(getType()).size() < maxCountOnCell) {
                    previousCell = destinationCell;
                } else {
                    destinationCell = previousCell;
                }
            }
            if (destinationCell != null && !destinationCell.equals(startCell)) {
                if (isALive()) {
                    safeMove(startCell, destinationCell);
                }
            }
        }
    }

    protected void safeMove(Cell source, Cell destination) {
        if (safeAddTo(destination)) {
            if (!safePollFrom(source)) {
                safePollFrom(destination);
            }
        }
    }

    protected boolean safeAddTo(Cell cell) {
        cell.getLock().lock();
        try {
            Set<Organism> set = cell.getResidents().get(getType());
            int maxCount = getLimit().getCOUNT_ON_CELL();
            int size = set.size();
            return size < maxCount && set.add(this);
        } finally {
            cell.getLock().unlock();
        }
    }

    protected boolean safePollFrom(Cell cell) {
        cell.getLock().lock();
        try {
            return cell.getResidents().get(getType()).remove(this);
        } finally {
            cell.getLock().unlock();
        }
    }

    @Override
    public void spawn(Cell currentCell) {
        currentCell.getLock().lock();
        try {
            double minWeightRatio = sex.equals(Sex.FEMALE)?0.9:0.5;
            if(isALive() && getWeight() > getLimit().getMAX_WEIGHT() * minWeightRatio){
                Sex partnerSex = sex.equals(Sex.FEMALE)?Sex.MALE:Sex.FEMALE;
                Set<Organism> partners = getPartners(currentCell, partnerSex);
                if (partners.size() > 0){
                    Sex childSex = Sex.values()[RandomGenerator.random(0, Sex.values().length -1)];
                    Animal child = (Animal) Organism.replicate(getPrototype());
                    child.setSex(childSex);
                    if (sex.equals(Sex.FEMALE)) {
                        setWeight(getWeight() - getWeight() * 0.3);
                    }
                }
            }
        }
        finally {
            currentCell.getLock().unlock();
        }
    }

    private double getWeightToEat() {
        double maxEatingWeight = LIMIT.getMAX_EATING_WEIGHT();
        double hungryWeight = LIMIT.getMAX_WEIGHT() - this.getWeight();
        return Math.min(hungryWeight, maxEatingWeight);
    }

    private Set<Organism> getPartners(Cell cell, Sex partnerSex){
        double minWeightRatio = partnerSex.equals(Sex.FEMALE)?0.9:0.5;
        Set<Organism> partners;
        partners = cell
                .getResidents()
                .get(getType())
                .stream()
                .map(o ->((Animal) o))
                .filter(a->a.isALive()
                        && partnerSex.equals(a.getSex())
                        && a.getWeight() > a.getWeight()*minWeightRatio)
                .collect(Collectors.toSet());
        return partners;
    }

    private Organism getPrototype(){
        Organism organism = null;
        for (Organism prototype : Configuration.get().getPrototypes()) {
            if (getType().equalsIgnoreCase(prototype.getClass().getSimpleName())){
                organism = prototype;
            }
        }
        if (organism != null){
            return organism;
        } else {
            throw new IslandException("Prototype not found");
        }
    }
}
