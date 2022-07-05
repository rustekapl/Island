package ru.javarush.island.synckevich.entities.animals.carnivores;

import ru.javarush.island.synckevich.entities.animals.Animal;

public class Snake extends Carnivore {

    public Snake() {
        setWeight(15.0);
        setMaxOnCell(30);
        setSpeed(1);
        setHungryPoints(3.0);
        setHealthPoints(3.0);
    }

    public Animal reproduce() {
        return new Snake();
    }
}
