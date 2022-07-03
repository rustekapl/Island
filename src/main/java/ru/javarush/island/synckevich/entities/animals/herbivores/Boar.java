package ru.javarush.island.synckevich.entities.animals.herbivores;

import ru.javarush.island.synckevich.entities.animals.Animal;

public class Boar extends Herbivore {
    public Boar() {
        setWeight(400.0);
        setMaxOnCell(50);
        setSpeed(2);
        setHungryPoints(50.0);
        setHealthPoints(50.0);
    }

    public Animal reproduce() {
        return new Boar();
    }
}
