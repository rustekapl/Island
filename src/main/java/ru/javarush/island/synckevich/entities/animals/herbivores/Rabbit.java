package ru.javarush.island.synckevich.entities.animals.herbivores;

import ru.javarush.island.synckevich.entities.animals.Animal;

public class Rabbit extends Herbivore {

    public Rabbit() {
        setWeight(2.0);
        setMaxOnCell(150);
        setSpeed(2);
        setHungryPoints(0.45);
        setHealthPoints(0.45);
    }

    public Animal reproduce() {
        return new Rabbit();
    }
}
