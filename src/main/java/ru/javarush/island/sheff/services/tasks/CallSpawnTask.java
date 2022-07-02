package ru.javarush.island.sheff.services.tasks;

import ru.javarush.island.sheff.entities.map.Cell;
import ru.javarush.island.sheff.entities.organisms.Organism;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class CallSpawnTask extends Task {

    public CallSpawnTask(Cell[] cells) {
        this.cells = cells;
    }

    @Override
    public Boolean call() {
        Arrays.stream(cells).forEach(cell -> cell.getResidents()
                .values()
                .stream()
                .flatMap(Collection::stream)
                .filter(organisms -> !organisms.isDead() && organisms.isFemaleGender() && organisms.isCanBreed())
                .map(Organism::spawn)
                .flatMap(Set::stream)
                .collect(Collectors.toSet())
                .forEach(organisms -> {
                    if (cell.getResidents()
                            .get(organisms.getName())
                            .size() < organisms.getLimit().getMaxCount())
                        cell.getResidents()
                                .get(organisms.getName())
                                .add(organisms);
                }));
        System.out.println("Размножились");

        return true;
    }
}
