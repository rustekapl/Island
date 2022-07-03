package ru.javarush.island.aleev.entity.organism.animals;


import ru.javarush.island.aleev.entity.map.Cell;
import ru.javarush.island.aleev.entity.organism.Organism;
import ru.javarush.island.aleev.parameters.Parameters;


public abstract class Animal extends Organism {
    public Animal(Parameters parameters) {
        super(parameters);
    }




    public boolean move(Cell currentCell) {
return false;
            }


    public abstract void eat();

    public abstract void reproduct();


}
