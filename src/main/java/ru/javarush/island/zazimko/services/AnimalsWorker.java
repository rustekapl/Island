package ru.javarush.island.zazimko.services;

import ru.javarush.island.zazimko.classes.animals.Organism;
import ru.javarush.island.zazimko.gameField.Cell;
import ru.javarush.island.zazimko.gameField.Field;
import ru.javarush.island.zazimko.modificators.Status;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class AnimalsWorker extends Thread {
    private final Field field;
    private final Queue<Task> tasks = new ConcurrentLinkedQueue<>();

    public AnimalsWorker(Field field) {
        this.field = field;
    }

    @Override
    public void run() {
        //TODO Code style. Long code. Needs to be split into several methods
        Cell[][] cells = field.getCells();
        for (Cell[] cell : cells) {
            for (Cell value : cell) {
                if (value.getStatus() != Status.NONE) {
                    value.getLock().lock();
                    ConcurrentHashMap<Type, Set<Organism>> organisms = value.getOrganisms();
                    for (Map.Entry<Type, Set<Organism>> pair : organisms.entrySet()) {
                        Set<Organism> animalSet = pair.getValue();
                        try {
                            for (Organism animal1 : animalSet) {
                                tasks.add(new Task(animal1, value));
                            }

                        } finally {
                            value.getLock().unlock();
                        }
                        tasks.forEach(Task::doTask);
                        tasks.clear();
                    }
                }
            }
        }
    }
}

