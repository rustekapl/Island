package ru.javarush.island.synckevich.entities.animals.carnivores;

import ru.javarush.island.synckevich.entities.animals.Animal;

public class Bear extends Carnivore {
    public Bear() {
        setWeight(500.0);
        setMaxOnCell(5);
        setSpeed(2);
        setHungryPoints(80.0);
        setHealthPoints(80.0);
    }

    public Animal reproduce() {
        return new Bear();
    }
}
