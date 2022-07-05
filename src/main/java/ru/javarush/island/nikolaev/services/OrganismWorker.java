package ru.javarush.island.nikolaev.services;

import ru.javarush.island.nikolaev.entity.map.Cell;
import ru.javarush.island.nikolaev.entity.map.GameMap;
import ru.javarush.island.nikolaev.entity.organizms.Organism;
import ru.javarush.island.nikolaev.entity.organizms.animals.Animal;

import java.lang.reflect.Type;
import java.util.Objects;
import java.util.Set;

public class OrganismWorker implements Runnable {

    private final Organism prototype;
    private final GameMap gameMap;

    public OrganismWorker(Organism prototype, GameMap gameMap) {
        this.prototype = prototype;
        this.gameMap = gameMap;
    }

    @Override
    public void run() {
        Cell[][] cells = gameMap.getCells();
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                Type type = prototype.getClass();
                Set<Organism> organisms = cell.getResidents().get(type);
                if (Objects.nonNull(organisms)) {
                    for (Organism organism : organisms) {
                        if (organism instanceof Animal animal && !organisms.isEmpty()) {
                            boolean destination = animal.move(cell);
                            System.out.print(cell + ">" + destination + " ");
                        } else {
                            prototype.spawn(cell);
                        }
                    }
                }
            }
        }
    }
}
