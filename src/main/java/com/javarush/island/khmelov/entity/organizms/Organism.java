package com.javarush.island.khmelov.entity.organizms;

import com.javarush.island.khmelov.abstraction.entity.Reproducible;
import com.javarush.island.khmelov.entity.map.Cell;
import com.javarush.island.khmelov.util.Probably;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

@SuppressWarnings("unused")
@Getter
@EqualsAndHashCode(of = "id")
public abstract class Organism implements Reproducible, Cloneable {

    private final static AtomicLong idCounter = new AtomicLong(System.currentTimeMillis());

    public Organism(String name, String icon, Limit limit) {
        this.name = name;
        this.icon = icon;
        this.limit = limit;
        weight = Probably.random(limit.getMaxWeight() / 2, limit.getMaxWeight());
    }

    private long id = idCounter.incrementAndGet();
    private final String type = this.getClass().getSimpleName();
    private final String name;
    private final String icon;

    //приготовим букву заранее
    private transient final String letter = getClass().getSimpleName().substring(0, 1);
    @Setter
    private double weight;
    private final Limit limit;

    @Override
    public String toString() {
        return icon;
    }

    @Override
    protected Organism clone() throws CloneNotSupportedException {
        //visible in inherits (cast to Organism)
        Organism clone = (Organism) super.clone();
        clone.id = idCounter.incrementAndGet();
        clone.weight = Probably.random(limit.getMaxWeight() / 2, limit.getMaxWeight());
        return clone;
    }

    @SuppressWarnings("unchecked")
    public static <T extends Organism> T clone(T original) {
        //for clients (cast to original Type)
        try {
            return (T) original.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }

    }


    protected boolean die(Cell target) {
        target.getLock().lock();
        try {
            return target.getResidents().get(type).remove(this);

        } finally {
            target.getLock().unlock();
        }
    }

    protected boolean changeWeight(Cell currentCell, int percent) {
        currentCell.getLock().lock();
        try {
            double maxWeight = limit.getMaxWeight();
            weight += maxWeight * percent / 100;
            weight = Math.max(0, weight);
            weight = Math.min(weight, maxWeight);
            return currentCell.getResidents().get(type).contains(this);
        } finally {
            currentCell.getLock().unlock();
        }
    }


    protected boolean move(Cell source, Cell destination) {
        if (addTo(destination)) { //if was added
            if (pollFrom(source)) { //and after was extract
                return true; //ok
            } else {
                pollFrom(destination); //die or eaten
            }
        }
        return false;
    }

    protected boolean addTo(Cell cell) {
        cell.getLock().lock();
        try {
            Set<Organism> set = cell.getResidents().get(getType());
            int maxCount = getLimit().getMaxCount();
            int size = set.size();
            return size < maxCount && set.add(this);
        } finally {
            cell.getLock().unlock();
        }
    }

    protected boolean pollFrom(Cell cell) {
        cell.getLock().lock();
        try {
            return cell.getResidents().get(getType()).remove(this);
        } finally {
            cell.getLock().unlock();
        }
    }

}
