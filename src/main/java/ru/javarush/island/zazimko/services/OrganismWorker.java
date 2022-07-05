package ru.javarush.island.zazimko.services;

import ru.javarush.island.zazimko.entity.map.Cell;
import ru.javarush.island.zazimko.entity.map.GameMap;
import ru.javarush.island.zazimko.entity.organizms.Organism;
import ru.javarush.island.zazimko.entity.organizms.Organisms;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class OrganismWorker implements Runnable {

    private final Organism prototype;
    private final GameMap gameMap;
    private final Queue<Task> tasks = new ConcurrentLinkedQueue<>();

    public OrganismWorker(Organism prototype, GameMap gameMap) {
        this.prototype = prototype;
        this.gameMap = gameMap;
    }

    //TODO  Coding. Ctrl_C Ctrl_V ??? But we like original coding.
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

    //TODO  Coding. Ctrl_C Ctrl_V ??? But we like original coding.
    private void processOneCell(Cell cell) {
        String type = prototype.getType();
        Organisms organisms = cell.getResidents().get(type);
        if (Objects.nonNull(organisms)) {
            cell.getLock().lock();
            try {
                organisms.forEach(organism -> {
                    //here possible action-cycle for entity (enum, collection or array)
                    tasks.add(new Task(organism, cell));
                });
            } finally {
                cell.getLock().unlock();
            }

            //run tasks
            //see CQRS pattern or CommandBus pattern and Producer-Consumer problem.
            //This cycle can to run in other thread or threads (pool)
            tasks.forEach(Task::doTask);
            tasks.clear();
        }
    }
}
