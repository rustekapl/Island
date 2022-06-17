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

public class OrganismWorker implements Runnable {

    private final Organism prototype;
    private final GameMap gameMap;
    private final Queue<Task> tasks=new ArrayDeque<>();

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
                    Type type = prototype.getClass();
                    Set<Organism> organisms = cell.getResidents().get(type);
                    if (Objects.nonNull(organisms)) {
                        for (Organism organism : organisms) {
                            if (organism instanceof Animal animal) {
                                //animal.eat(destination);
                                //animal.spawn(destination);
                                tasks.add(animal.move(cell));
                            } else {
                                //tasks.add(prototype.spawn(cell));
                            }
                        }
                        tasks.forEach(Task::safeTodoTaskAndSubTasks);
                        tasks.clear();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }


    }
}
