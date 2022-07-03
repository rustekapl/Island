package ru.javarush.island.komlev.services;

import ru.javarush.island.komlev.etnity.map.Cell;
import ru.javarush.island.komlev.etnity.map.GameMap;
import ru.javarush.island.komlev.etnity.organizms.Organism;
import ru.javarush.island.komlev.etnity.organizms.animals.Animal;

import java.lang.reflect.Type;
import java.util.Set;

public class OrganismWorker implements Runnable {
    private final Organism germ;
    private final GameMap gameMap;

    public OrganismWorker(Organism germ, GameMap gameMap) {
        this.germ = germ;
        this.gameMap = gameMap;
    }

    @Override
    public void run() {
        Cell[][] cells = gameMap.getCells();
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                Type type = germ.getClass();
                Set<Organism> organisms = cell.getResidents().get(type);
                for (Organism organism : organisms) {
                    if (organism instanceof Animal animal) {
                        animal.eat(cell);
                        animal.move(cell);
                    } else {
                        germ.spawn(cell);
                    }
                }
            }
        }

    }
}