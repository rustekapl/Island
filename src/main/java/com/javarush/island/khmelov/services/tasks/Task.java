package com.javarush.island.khmelov.services.tasks;

import com.javarush.island.khmelov.entity.map.Cell;
import com.javarush.island.khmelov.entity.organizms.Organism;
import lombok.Getter;

import java.lang.reflect.Type;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.IntStream;

@Getter
public class Task {

    private final Cell cell;
    private final Consumer<Cell> operation;

    private Task(Cell cell, Consumer<Cell> operation) {
        this.cell = cell;
        this.operation = operation;
    }

    public static Task bornClone(Organism organism, Cell cell, int count) {
        return new Task(cell, c -> {
            c.getLock().lock();
            try {
                Set<Organism> organisms = c.getResidents().get(organism.getClass());
                for (int i = 0; i < count; i++) {
                    organisms.add(Organism.clone(organism));
                }
            } finally {
                c.getLock().unlock();
            }
        });
    }

    public static Task die(Organism organism, Cell target) {
        return new Task(target, c -> {
            c.getLock().lock();
            try {
                Set<Organism> organisms = target.getResidents().get(organism.getClass());
                if (Objects.nonNull(organisms)) {
                    organisms.remove(organism);
                }
            } finally {
                c.getLock().unlock();
            }
        });
    }

    public static Task slim(Organism organism, Cell currentCell, int percent) {
        return new Task(currentCell, c -> {
            c.getLock().lock();
            try {
                double weight = organism.getWeight();
                weight -= organism.getLimit().getMaxWeight() / percent;
                organism.setWeight(weight);
            } finally {
                c.getLock().unlock();
            }
        });
    }

    public static Task move(Organism organism, Cell from, Cell to) {
        return new Task(from, c -> {
            Type type = organism.getClass();
            to.getResidents().putIfAbsent(type, new HashSet<>());
            boolean extractOrganism = false;
            from.getLock().lock();
            try {
                Set<Organism> source = c.getResidents().get(type);
                if (to.getResidents().get(type).size() < organism.getLimit().getMaxCount()) {
                    extractOrganism = source.remove(organism);
                }
            } finally {
                from.getLock().unlock();
            }
            if (extractOrganism) {
                to.getLock().lock();
                try {
                    to.getResidents().get(type).add(organism);
                } finally {
                    to.getLock().unlock();
                }
            }
        });
    }

    public void run() {
        operation.accept(cell);
    }


}
