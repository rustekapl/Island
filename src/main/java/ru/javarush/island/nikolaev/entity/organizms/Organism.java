package ru.javarush.island.nikolaev.entity.organizms;

import lombok.Getter;
import lombok.Setter;
import ru.javarush.island.nikolaev.abstraction.entity.Reproducible;
import ru.javarush.island.nikolaev.entity.map.Cell;

import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

@SuppressWarnings("unused")
@Getter
public abstract class Organism implements Reproducible, Cloneable {

    private final static AtomicLong idCounter = new AtomicLong(System.currentTimeMillis());

    public Organism(String name, String icon, double weight, int idFromTheSpecTable, Limit limit) {
        this.name = name;
        this.icon = icon;
        this.weight = weight;
        this.idFromTheSpecTable = idFromTheSpecTable;
        this.limit = limit;

    }

    private long id = idCounter.incrementAndGet();
    private final String name;

    private final String type = this.getClass().getSimpleName();
    private final String icon;

    private final int idFromTheSpecTable;
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
        return clone;
    }

    @SuppressWarnings("unchecked")
    public static <T extends Organism> T clone(T original) {
        //for clients (cast to original Type)
        try {
            Organism clone = original.clone();
            return (T) clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }

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

    protected boolean safeAddTo(Cell cell) {
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

    protected boolean safePollFrom(Cell cell) {
        cell.getLock().lock();
        try {
            return cell.getResidents().get(getType()).remove(this);
        } finally {
            cell.getLock().unlock();
        }
    }
}
