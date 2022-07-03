package ru.javarush.island.zazimko.services;

import lombok.Getter;
import ru.javarush.island.zazimko.entity.map.Cell;
import ru.javarush.island.zazimko.entity.organizms.Organism;
import ru.javarush.island.zazimko.entity.organizms.animals.Animal;

@Getter
public class Task {

    private final Organism organism;
    private final Cell cell;

    public Task(Organism organism, Cell cell) {
        this.organism = organism;
        this.cell = cell;
    }

    public void doTask() {
        if (organism instanceof Animal animal) {
            if (animal.eat(cell)) {
                animal.spawn(cell);
                animal.move(cell);
            }
        } else {
            organism.spawn(cell);
        }
    }

}