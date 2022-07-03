package ru.javarush.island.stepanov.entities.creatures.animals.predators;

import ru.javarush.island.stepanov.entities.creatures.animals.Animal;

public abstract class Predator extends Animal {
    public Predator(){
        super();
    }

    @Override
    public Predator clone() {
        return (Predator) super.clone();
    }
}
