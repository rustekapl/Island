package ru.javarush.island.aleev.entity.organism.animals.carnivores;


import ru.javarush.island.aleev.entity.organism.animals.herbivores.Herbivore;
import ru.javarush.island.aleev.parameters.Parameters;

import java.util.List;

public class Wolf extends Carnivore {

    public Wolf(Parameters parameters) {
        super(parameters);
    }


    @Override
    public void eat(List<Herbivore> herbivores) {
        //TODO ---  ?????
    }

    @Override
    public void move() {
        super.move();
    }

    @Override
    public void eat() {
        //TODO ---  ?????
    }

    @Override
    public void reproduct() {
        super.reproduct();
    }


}
