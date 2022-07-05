package ru.javarush.island.sheff.services.tasks;

import ru.javarush.island.sheff.entities.map.Cell;
import ru.javarush.island.sheff.entities.organisms.Organism;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class MovingAnimalsTask extends Task {

    Set<Organism> organismSet;

    public MovingAnimalsTask(Cell[] cells, Set<Organism> organismSet) {
        this.cells = cells;
        this.organismSet = organismSet;
    }

    @Override
    public Boolean call() {
        Arrays.stream(cells).forEach(cell -> cell.getNewResidents()
                .forEach((s, organisms) -> organisms.addAll(organismSet
                        .stream()
                        .filter(organism -> organism.getName().equals(s) && organism.getLocation().getCol() == cell.getCol())
                        .collect(Collectors.toSet()))));

        System.out.println("Переместились");
        return true;
    }
}