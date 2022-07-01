package ru.javarush.island.khryukin.services;

import ru.javarush.island.khryukin.entity.animals.Animal;
import ru.javarush.island.khryukin.entity.organisms.Organism;
import ru.javarush.island.khryukin.entity.map.Cell;
import ru.javarush.island.khryukin.entity.map.GameMap;

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
                    //TODO replace it -> throw...
                    e.printStackTrace();
                    System.err.println("OMG. Debug it!");
                    System.exit(0);
                }
            }
        }
    }
    private void processOneCell(Cell cell) {
        String type = prototype.getType();
        Set<Organism> organisms = cell.getResidents().get(type);
        if (Objects.nonNull(organisms)) {
            //build tasks (need correct iteration, without any modification)
            cell.getLock().lock(); //ONLY READ
            try {
                organisms.forEach(organism -> {
                    //here possible action-cycle for ru.javarush.island.khryukin.entity (enum, collection or array)
                    Task task = new Task(organism, o -> {
                        o.spawn(cell);
                        if (organism instanceof Animal animal) {
                            //animal.eat(cell);
                            animal.move(cell);
                        }
                    });
                    tasks.add(task);
                });
            } finally {
                cell.getLock().unlock();
            }

            //run tasks
            //see CQRS pattern or CommandBus pattern and Producer-Consumer problem.
            //This cycle can to run in other thread or threads (pool)
            tasks.forEach(Task::run);
            tasks.clear();
        }
    }
}
