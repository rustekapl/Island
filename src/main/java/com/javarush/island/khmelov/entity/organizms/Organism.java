package com.javarush.island.khmelov.entity.organizms;

import com.javarush.island.khmelov.abstraction.entity.Reproducible;
import com.javarush.island.khmelov.entity.map.Cell;
import com.javarush.island.khmelov.entity.tasks.Task;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

@SuppressWarnings("unused")
@Getter
@EqualsAndHashCode(of = "id")
public abstract class Organism implements Reproducible, Cloneable {

    private final static AtomicLong idCounter = new AtomicLong(System.currentTimeMillis());

    public Organism(String name, String icon, double weight, Limit limit) {
        this.name = name;
        this.icon = icon;
        this.weight = weight;
        this.limit = limit;
    }

    private long id = idCounter.incrementAndGet();
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

    @Override
    public Task spawn(Cell currentCell) {
        Type type = this.getClass();
        Map<Type, Set<Organism>> residents = currentCell.getResidents();
        Set<Organism> organisms = residents.get(type);
        return (Objects.nonNull(organisms)
                && organisms.contains(this)
                && organisms.size() > 2)
                ? bornClone(currentCell)
                : null;
    }

    protected Cell findDestinationCell(Cell startCell, int countCellForStep) {
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
    private Task bornClone(Cell cell) {
        return new Task(cell, c -> c.getResidents()
                .get(this.getClass())
                .add(clone(this)));
    }
}
