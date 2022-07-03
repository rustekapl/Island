package ru.javarush.island.komlev.services;

import ru.javarush.island.komlev.etnity.organizms.Organism;

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

    public Consumer<Organism> getOperation() {
        return operation;
    }

    public void run() {
        operation.accept(organism);
    }
}
