package ru.javarush.island.smulko.entity.organizms.animals;

import ru.javarush.island.smulko.abstractions.Moveable;
import ru.javarush.island.smulko.entity.map.Cell;
import ru.javarush.island.smulko.entity.organizms.Organism;
import ru.javarush.island.smulko.entity.preferences.Fields;

public abstract class Animal
        extends Organism
        implements Moveable {

    public Animal(Fields fields) {
        super(fields);
    }

    @Override
    public void move(Cell start) {
        int steps = this.getSpeed();
        Cell target = start.getLastCell(steps);
        target.addOrganismToSet(this.getClass(), this);
        start.removeOrganismFromSet(this.getClass(), this);
    }

}
