package ru.javarush.island.khryukin.services;

import ru.javarush.island.khryukin.entity.animals.Animal;
import ru.javarush.island.khryukin.entity.animals.organisms.Organism;
import ru.javarush.island.khryukin.entity.map.Cell;
import ru.javarush.island.khryukin.entity.map.GameMap;

import java.lang.reflect.Type;
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
                //TODO Code style. Needs reformat. One line - one method
                Set<Organism> organisms = cell.getResidents().get(type);
                for (Organism organism : organisms) {
                    if (organism instanceof Animal animal) {
                        //Cell destination = animal.move(cell);
                        animal.move(cell);
                        //animal.eat(destination);
                        //animal.spawn(destination);
                    } else {
                        prototype.spawn(cell);
                    }
                }
            }
        }
    }
}
