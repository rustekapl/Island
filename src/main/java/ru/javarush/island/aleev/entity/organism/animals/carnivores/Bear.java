package ru.javarush.island.aleev.entity.organism.animals.carnivores;


import ru.javarush.island.aleev.entity.organism.animals.herbivores.Herbivore;
import ru.javarush.island.aleev.parameters.Parameters;

import java.util.List;

public class Bear extends Carnivore {

    public Bear(Parameters parameters) {
        super(parameters);
    }


    @Override
    public void eat(List<Herbivore> herbivores) {

    }

    @Override
    public void move() {
        super.move();
    }

    @Override
    public void eat() {

    }

    @Override
    public void reproduct() {
        super.reproduct();
    }


}
