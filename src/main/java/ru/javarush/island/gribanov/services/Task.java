package ru.javarush.island.gribanov.services;

import ru.javarush.island.gribanov.entity.lives.Organism;

import java.util.function.Consumer;


public class Task {

    private final Organism organism;
    private final Consumer<Organism> operation;

    public Task(Organism organism, Consumer<Organism> operation) {
        this.organism = organism;
        this.operation = operation;
    }

    public Organism getOrganism() {
        return organism;
    }

    public void run() {
        operation.accept(organism);
    }


}
