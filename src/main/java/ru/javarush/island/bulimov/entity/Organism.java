package ru.javarush.island.bulimov.entity;

import ru.javarush.island.bulimov.abstractions.Reproducing;
import ru.javarush.island.bulimov.exception.IslandRunException;
import ru.javarush.island.bulimov.islandMap.Cell;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

public abstract class Organism implements Reproducing, Cloneable{
    private final static AtomicLong idCounter = new AtomicLong(System.currentTimeMillis());



    private long id = idCounter.incrementAndGet();
    public String name;
    public String icon;
    public double weight;
    public int maxItemCell;
    public double saturation;
    public boolean pregnancy = false;
    public boolean check = false;




    public Organism(double weight, int maxItemCell , double saturation) {
        this.weight = weight;
        this.maxItemCell = maxItemCell;
        this.saturation = saturation;
    }
    @Override
    public boolean reproducing(Cell cell) {
        cell.getLock().lock();
        try{
            if(cell.getAnimalsCell().get(this.name).size() <= this.maxItemCell/2){
                cell.getAnimalsCell().get(this.name).add(Organism.clone(this));
                return true;
            }
            return false;
        }
        finally {
            cell.getLock().unlock();
        }


    }


    @Override
    protected Organism clone() throws CloneNotSupportedException{
        Organism clone = (Organism) super.clone();
        clone.id = idCounter.incrementAndGet();
        clone.weight = ThreadLocalRandom.current().nextDouble(clone.weight/2, clone.weight);
        return clone;
    }
    public static <T extends Organism> T clone(T original) {
        try {
            //TODO ---  suppress the warnings
            return (T) original.clone();
        } catch (CloneNotSupportedException e) {
            throw new IslandRunException("Cloneable error"+ e);
        }

    }
    public void aging(Cell cell){
        cell.getLock().lock();
        try{
            this.weight-=0.5;
        }
        finally {
            cell.getLock().unlock();
        }
    }
    public void deleteDead(Cell cell) {
        cell.getLock().lock();
        try{
            cell.getAnimalsCell().get(this.name).removeIf(organism -> organism.weight<=0.0);
        }
        finally {
            cell.getLock().unlock();
        }
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Organism organism)) return false;
        return id == organism.id && Double.compare(organism.weight, weight) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, weight, maxItemCell, saturation, pregnancy, check);
    }

}
