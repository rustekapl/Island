package ru.javarush.island.bulimov.services;

import ru.javarush.island.bulimov.entity.Organism;
import ru.javarush.island.bulimov.entity.animals.Animal;
import ru.javarush.island.bulimov.islandMap.Cell;

public class Task {

    private final Organism organism;
    private final Cell cell;

    public Task(Organism organism, Cell cell) {
        this.organism = organism;
        this.cell = cell;
    }

    public void doTask() {
        if (organism instanceof Animal animal) {
            if (animal.eating(cell)) {
                animal.reproducing(cell);
            }
            animal.moving(cell);
        } else {
            organism.reproducing(cell);
        }
        organism.aging(cell);
        organism.deleteDead(cell);

    }

}
