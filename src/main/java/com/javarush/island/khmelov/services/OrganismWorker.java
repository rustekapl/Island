package com.javarush.island.khmelov.services;

import com.javarush.island.khmelov.entity.map.Cell;
import com.javarush.island.khmelov.entity.map.GameMap;
import com.javarush.island.khmelov.entity.organizms.Organism;
import com.javarush.island.khmelov.entity.organizms.animals.Animal;
import com.javarush.island.khmelov.entity.tasks.Task;

import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

public class OrganismWorker implements Runnable {

    private final Organism prototype;
    private final GameMap gameMap;
    private final Queue<Task> tasks = new ConcurrentLinkedQueue<>();

    public OrganismWorker(Organism prototype, GameMap gameMap) {
        this.prototype = prototype;
        this.gameMap = gameMap;
    }

    @Override
    public void run() {
        Cell[][] cells = gameMap.getCells();
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                try {
                    processOneCell(cell);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.err.println("Debug it!");
                    System.exit(0);
                }
            }
        }
    }

    private void processOneCell(Cell cell) {
        Type type = prototype.getClass();
        Set<Organism> organisms = cell.getResidents().get(type);
        if (Objects.nonNull(organisms)) {
            cell.getLock().lock();
            try {
                organisms.forEach(organism -> {
                    tasks.add(organism.spawn(cell));
                    if (organism instanceof Animal animal) {
                        System.out.print(animal);
                        tasks.add(animal.eat(cell));
                        tasks.add(animal.move(cell));
                    }
                });
                System.out.println();
            } finally {
                cell.getLock().unlock();
            }
            tasks.forEach(Task::run);
            tasks.clear();
        }
    }
}
