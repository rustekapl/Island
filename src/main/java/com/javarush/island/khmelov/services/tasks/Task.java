package com.javarush.island.khmelov.services.tasks;

import com.javarush.island.khmelov.entity.map.Cell;
import com.javarush.island.khmelov.entity.organizms.Organism;
import lombok.Getter;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;

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
                double childWeight = organism.getWeight() / (count+1)*1.1;
                organism.setWeight(childWeight);
                Set<Organism> organisms = c.getResidents().get(organism.getType());
                for (int i = 0; i < count; i++) {
                    Organism clone = Organism.clone(organism);
                    clone.setWeight(childWeight);
                    organisms.add(clone);
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
                Set<Organism> organisms = target.getResidents().get(organism.getType());
                if (Objects.nonNull(organisms)) {
                    organisms.remove(organism);
                }
            } finally {
                c.getLock().unlock();
            }
        });
    }

    public static Task slim(Organism organism, Cell currentCell, int percent) {
        return new Task(currentCell, cell -> {
            cell.getLock().lock();
            try {
                double weight = organism.getWeight();
                weight -= organism.getLimit().getMaxWeight() / percent;
                organism.setWeight(weight);
            } finally {
                cell.getLock().unlock();
            }
        });
    }

    public static Task move(Organism organism, Cell from, Cell to) {
        return new Task(from, cell -> {
            String type = organism.getType();
            to.getResidents().putIfAbsent(type, new HashSet<>());
            boolean extractOrganism = false;
            from.getLock().lock();
            try {
                Set<Organism> source = cell.getResidents().get(type);
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
