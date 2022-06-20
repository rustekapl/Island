package com.javarush.island.khmelov.entity.organizms;

import com.javarush.island.khmelov.abstraction.entity.Reproducible;
import com.javarush.island.khmelov.entity.map.Cell;
import com.javarush.island.khmelov.services.tasks.Task;
import com.javarush.island.khmelov.util.Probably;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
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
    private String type = this.getClass().getSimpleName();
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
        type = this.getClass().getSimpleName();
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

    @Override
    public Task spawn(Cell currentCell) {
        Map<String, Set<Organism>> residents = currentCell.getResidents();
        Set<Organism> organisms = residents.get(type);
        int count = Probably.random(0, 10) < 8 ? 0 : //TODO 10==off
                organisms.contains(this)
                        && organisms.size() > 2
                        && organisms.size() < this.getLimit().getMaxCount()
                        ? 1 : 0;
        return Task.bornClone(this, currentCell, count);
    }

}
