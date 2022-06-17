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

public abstract class Animal
        extends Organism
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
        Cell destinationCell = findDestinationCell(startCell, countCellForStep);
        return moveMe(startCell, destinationCell);
    }

    private Task moveMe(Cell from, Cell to) {
        Type type = this.getClass();
        to.getResidents().putIfAbsent(type, new HashSet<>());
        return new Task(from, c -> {
            c.getResidents().get(type).remove(this);
            to.getResidents().get(type).add(this);
        });
    }
}
