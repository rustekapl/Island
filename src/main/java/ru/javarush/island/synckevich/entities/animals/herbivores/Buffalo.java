package ru.javarush.island.synckevich.entities.animals.herbivores;

import ru.javarush.island.synckevich.entities.animals.Animal;

public class Buffalo extends Herbivore {

    public Buffalo() {
        setWeight(700.0);
        setMaxOnCell(10);
        setSpeed(3);
        setHungryPoints(100.0);
        setHealthPoints(100.0);
    }

    public Animal reproduce() {
        return new Buffalo();
    }
}
