package ru.javarush.island.synckevich.entities.animals.herbivores;

import ru.javarush.island.synckevich.entities.animals.Animal;

public class Duck extends Herbivore {

    public Duck() {
        setWeight(1.0);
        setMaxOnCell(200);
        setSpeed(4);
        setHungryPoints(0.15);
        setHealthPoints(0.15);
    }

    public Animal reproduce() {
        return new Duck();
    }
}
