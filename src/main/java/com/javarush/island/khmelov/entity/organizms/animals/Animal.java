package com.javarush.island.khmelov.entity.organizms.animals;

import com.javarush.island.khmelov.abstraction.entity.Eating;
import com.javarush.island.khmelov.abstraction.entity.Movable;
import com.javarush.island.khmelov.abstraction.entity.Reproducible;
import com.javarush.island.khmelov.entity.map.Cell;
import com.javarush.island.khmelov.entity.organizms.Limit;
import com.javarush.island.khmelov.entity.organizms.Organism;
import com.javarush.island.khmelov.services.tasks.Task;

public abstract class Animal extends Organism implements Eating, Reproducible, Movable {

    public Animal(String name, String icon,  Limit limit) {
        super(name, icon, limit);
    }

    @Override
    public Task eat(Cell currentCell) {
//        if ()
        if (this.getWeight() <= 0) {
            return Task.die(this, currentCell);
        }
        return Task.slim(this, currentCell, 10);
    }


    @Override
    public Task move(Cell startCell) {
        int countStep = this.getLimit().getMaxSpeed();
        Cell destinationCell = startCell.getDestinationCell(countStep);
        return Task.move(this, startCell, destinationCell);
    }


}
