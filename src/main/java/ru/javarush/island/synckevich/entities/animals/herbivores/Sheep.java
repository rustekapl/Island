package ru.javarush.island.synckevich.entities.animals.herbivores;

import ru.javarush.island.synckevich.entities.animals.Animal;

public class Sheep extends Herbivore {

    public Sheep() {
        setWeight(70.0);
        setMaxOnCell(140);
        setSpeed(3);
        setHungryPoints(15.0);
        setHealthPoints(15.0);
    }

    public Animal reproduce() {
        return new Sheep();
    }
}
