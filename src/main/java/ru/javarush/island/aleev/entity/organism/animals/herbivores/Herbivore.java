package ru.javarush.island.aleev.entity.organism.animals.herbivores;


import ru.javarush.island.aleev.entity.map.Cell;
import ru.javarush.island.aleev.entity.organism.animals.Animal;
import ru.javarush.island.aleev.parameters.Parameters;


public abstract class Herbivore extends Animal {


    public Herbivore(Parameters parameters) {
        super(parameters);
    }


    public abstract void eat(Cell curentCell);

    @Override
    public void move() {

    }

    @Override
    public void reproduct() {

    }


}
