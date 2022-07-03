package ru.javarush.island.stepanov.entities.creatures.animals.herbivores;

import ru.javarush.island.stepanov.entities.creatures.animals.Animal;

public class Herbivore extends Animal {
    public Herbivore(){
    }

    @Override
    public Herbivore clone() {
        return (Herbivore) super.clone();
    }
}
