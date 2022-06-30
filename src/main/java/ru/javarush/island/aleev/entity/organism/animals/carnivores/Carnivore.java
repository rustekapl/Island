package ru.javarush.island.aleev.entity.organism.animals.carnivores;


import ru.javarush.island.aleev.entity.organism.animals.Animal;
import ru.javarush.island.aleev.entity.organism.animals.herbivores.Herbivore;
import ru.javarush.island.aleev.parameters.Parameters;

import java.util.List;

public abstract class Carnivore extends Animal {

    public Carnivore(Parameters parameters) {
        super(parameters);
    }


    public abstract void eat(List<Herbivore> herbivores);


    public void move() {
        //TODO ---  ?????
    }

    @Override
    public void reproduct() {
        //TODO ---  ?????

    }

}
