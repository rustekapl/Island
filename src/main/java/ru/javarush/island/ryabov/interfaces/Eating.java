package ru.javarush.island.ryabov.interfaces;

import ru.javarush.island.ryabov.entity.map.Cell;
import ru.javarush.island.ryabov.entity.organisms.organism.plant.Plant;
import ru.javarush.island.ryabov.entity.organisms.types.Herbivore;
import ru.javarush.island.ryabov.entity.organisms.types.Organism;
import ru.javarush.island.ryabov.entity.organisms.types.Predator;
import ru.javarush.island.ryabov.util.Random;

import java.util.Map;

public interface Eating {
    default void eat(Cell cell) {
        cell.getLock().lock();
        if (this instanceof Predator) {
            if (cell.HERBIVORES.size() != 0) {
                if (cell.HERBIVORES.size() > 1000) {
                    Herbivore herbivore = cell.HERBIVORES.get(Random.random(0, cell.HERBIVORES.size()));
                    synchronized (cell) {
                        cell.HERBIVORES.remove(herbivore);
                        cell.ORGANISMS.remove(herbivore);
                    }
                    for (Map.Entry<Organism, Integer> organismIntegerEntry : cell.CELL_POPULATION.entrySet()) {
                        if (organismIntegerEntry.getKey().getClass().getSimpleName().equals(herbivore.getClass().getSimpleName())) {
                            cell.CELL_POPULATION.put(organismIntegerEntry.getKey(), organismIntegerEntry.getValue() - 1);
                        }
                    }
                }
            }
        } else {
            if (cell.PLANTS.size() != 0) {
                Plant plant = cell.PLANTS.get(Random.random(0, cell.PLANTS.size()));
                synchronized (cell) {
                    cell.PLANTS.remove(plant);
                    cell.ORGANISMS.remove(plant);
                }
                for (Map.Entry<Organism, Integer> organismIntegerEntry : cell.CELL_POPULATION.entrySet()) {
                    if (organismIntegerEntry.getKey().getClass().getSimpleName().equals(plant.getClass().getSimpleName())) {
                        cell.CELL_POPULATION.put(organismIntegerEntry.getKey(), organismIntegerEntry.getValue() - 1);
                    }
                }
            }
        }
        cell.getLock().unlock();
    }
}
