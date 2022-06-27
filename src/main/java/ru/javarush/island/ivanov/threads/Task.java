package ru.javarush.island.ivanov.threads;

import ru.javarush.island.ivanov.entities.Creature;

import java.util.function.Consumer;

public class Task {

    private final Creature creature;

    private final Consumer<Creature> operation;


    public Task(Creature creature, Consumer<Creature> operation) {
        this.creature = creature;
        this.operation = operation;
    }

    public void begin() {
        operation.accept(creature);
    }
}
