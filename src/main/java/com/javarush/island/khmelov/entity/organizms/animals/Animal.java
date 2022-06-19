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
import java.util.Set;

public abstract class Animal
        extends Organism
        implements Eating, Reproducible, Movable {

    public Animal(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }

    @Override
    public Task eat(Cell currentCell) {
        return die(currentCell);

//        if (this.getWeight() < this.getLimit().getMaxWeight() / 30) {
//            return die(currentCell);
//        }
//        return slim(currentCell);
    }

    private Task die(Cell currentCell) {
        return new Task(currentCell, c ->{
                currentCell.getResidents().get(this.getClass()).
                        remove(this);
        }
        );
    }

    private Task slim(Cell currentCell) {
        return new Task(currentCell, c -> {
            double weight = this.getWeight();
            weight -= this.getLimit().getMaxWeight() / 5;
            this.setWeight(weight);
        });
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
            Set<Organism> source = c.getResidents().get(type);
            Set<Organism> destination = to.getResidents().get(type);
            if (destination.size() < getLimit().getMaxCount()) {
                source.remove(this);
                destination.add(this);
            }
        });
    }
}
