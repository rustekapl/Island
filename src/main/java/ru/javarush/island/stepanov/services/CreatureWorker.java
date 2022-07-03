package ru.javarush.island.stepanov.services;

import ru.javarush.island.stepanov.entities.creatures.Creature;
import ru.javarush.island.stepanov.entities.location.Location;
import ru.javarush.island.stepanov.entities.location.LocationCell;
import lombok.ToString;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;


@ToString
public class CreatureWorker implements Runnable {

    private final String prototypeClassName;
    private final Location location;
    private final Queue<Task> taskQueue = new ConcurrentLinkedQueue<>();

    public CreatureWorker(String prototypeClassName, Location location) {
        this.prototypeClassName = prototypeClassName;
        this.location = location;
    }

    @Override
    public void run() {

        for (LocationCell cell: location.getCellsPool()) {
            resetCreaturesDaily(cell);
        }

        for (LocationCell cell: location.getCellsPool()) {
            populateQueue(cell);
        }
        taskQueue.forEach(Task::doDailyRoutine);    // run tasks for all cells
        taskQueue.clear();
    }

    private void resetCreaturesDaily(LocationCell cell) {
        for (Creature creature: cell.getCellInhabitants().get(prototypeClassName)) {
            creature.getIsReadyForAction().set(true);
            creature.removeWeightByPeriod();
        }
    }

    private void populateQueue(LocationCell cell) {
        cell.getLock().lock();
        try{
            for (Creature creature: cell.getCellInhabitants().get(prototypeClassName)) {
                Task task = new Task(creature, cell, location);
                taskQueue.add(task);}
        } finally {
            cell.getLock().unlock();
        }
    }
}
