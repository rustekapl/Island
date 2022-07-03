package ru.javarush.island.bulimov.services;

import ru.javarush.island.bulimov.entity.Organism;
import ru.javarush.island.bulimov.exception.IslandRunException;
import ru.javarush.island.bulimov.islandMap.Cell;
import ru.javarush.island.bulimov.islandMap.Island;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class OrganismWorker implements  Runnable{
    private final Organism organism;
    private final Island island;
    private final Queue<Task> tasks = new ConcurrentLinkedQueue<>();

    public OrganismWorker(Organism organism, Island island) {
        this.organism = organism;
        this.island = island;
    }


    @Override
    public void run() {
        Cell[][] cells = island.getAnimalMap();
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                try {
                    processOnCell(cell);
                } catch (Exception e) {
                    throw new IslandRunException("Problem operation with creature - " + this.organism.name, e);
                }
            }
        }
    }

    private void processOnCell(Cell cell){
        cell.getLock().lock();
        try{
            if(cell.getAnimalsCell().get(organism.name) != null){
                for (Organism organism : cell.getAnimalsCell().get(organism.name)) {
                    tasks.add(new Task(organism, cell));

                }
            }

        }
        finally {
            cell.getLock().unlock();
        }
        tasks.forEach(Task::doTask);
        tasks.clear();


    }
}
