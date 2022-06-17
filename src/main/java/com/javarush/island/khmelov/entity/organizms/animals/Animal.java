package com.javarush.island.khmelov.entity.organizms.animals;

import com.javarush.island.khmelov.abstraction.entity.Eating;
import com.javarush.island.khmelov.abstraction.entity.Movable;
import com.javarush.island.khmelov.abstraction.entity.Reproducible;
import com.javarush.island.khmelov.entity.map.Cell;
import com.javarush.island.khmelov.entity.organizms.Limit;
import com.javarush.island.khmelov.entity.organizms.Organism;
import com.javarush.island.khmelov.entity.tasks.Task;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;

public abstract class Animal
        extends com.javarush.island.khmelov.entity.organizms.Organism
        implements Eating, Reproducible, Movable {

    public Animal(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }

    @Override
    public void eat(Cell currentCell) {

    }


    @Override
    public Task move(Cell startCell) {
        int countCellForStep = this.getLimit().getMaxSpeed();
        Cell last = findLastCell(startCell, countCellForStep);
        return removeMe(startCell);//.andThen(addMe(last));
        //addMe(last);
    }



    private Cell findLastCell(Cell startCell, int countCellForStep) {
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

    private Task addMe(Cell cell) {
        Type type = this.getClass();
        return new Task(cell, c -> c.getResidents()
                .computeIfAbsent(type, o -> new HashSet<>())
                .add(this));
    }

    private Task removeMe(Cell cell) {
        Type type = this.getClass();
        return new Task(cell, c -> c.getResidents()
                .computeIfAbsent(type, o -> new HashSet<>())
                .remove(this));
    }

}
