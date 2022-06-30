package ru.javarush.island.aleev.entity.organism.plants;

import ru.javarush.island.aleev.entity.organism.Organism;
import ru.javarush.island.aleev.parameters.Parameters;

public abstract class Plants extends Organism {
    public Plants(Parameters parameters) {
        super(parameters);
    }


    @Override
    public void reproduct() {
        super.reproduct();
    }
}
