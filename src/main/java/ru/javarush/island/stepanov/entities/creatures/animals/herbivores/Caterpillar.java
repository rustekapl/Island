package ru.javarush.island.stepanov.entities.creatures.animals.herbivores;

public class Caterpillar extends Herbivore {
    public Caterpillar(){}

    @Override
    public void removeWeightByPeriod() {
    }

    @Override
    public boolean starved() {
        return false;
    }
}
