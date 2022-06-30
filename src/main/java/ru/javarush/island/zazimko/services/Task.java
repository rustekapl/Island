package ru.javarush.island.zazimko.services;

import lombok.Getter;
import ru.javarush.island.zazimko.classes.animals.Organism;
import ru.javarush.island.zazimko.classes.animals.carnivores.Carnivore;
import ru.javarush.island.zazimko.classes.animals.herbivores.Herbivores;
import ru.javarush.island.zazimko.gameField.Cell;


@Getter
public class Task {

    private final Organism organism;
    private final Cell cell;

    public Task(Organism organism, Cell cell) {
        this.organism = organism;
        this.cell = cell;
    }

    public void doTask() {
        if (organism instanceof Carnivore carnivore) {
            carnivore.toEat(cell);
            carnivore.toMultiply(cell);
            carnivore.toDie(cell);
            carnivore.toMove(cell);

        } else if (organism instanceof Herbivores herbivores) {
            herbivores.toEat(cell);
            herbivores.toMultiply(cell);
            herbivores.toDie(cell);
            herbivores.toMove(cell);

        }
    }

}
