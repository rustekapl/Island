package ru.javarush.island.sheff.services.tasks;

import ru.javarush.island.sheff.entities.map.Cell;
import ru.javarush.island.sheff.entities.organisms.Organism;

import java.util.Arrays;
import java.util.Collection;

public class CallEndTurnTask extends Task {

    public CallEndTurnTask(Cell[] cells) {
        this.cells = cells;
    }

    @Override
    public Boolean call() {

        Arrays.stream(cells).forEach(cell -> cell.getResidents()
                .values()
                .stream()
                .flatMap(Collection::stream)
                .filter(organisms -> !organisms.isDead())
                .forEach(Organism::endTurn));

        Arrays.stream(cells).forEach(cell -> cell.getResidents()
                .forEach((s, organisms) -> organisms.removeIf(Organism::isDead)));

        System.out.println("Конец хода");

        return true;
    }
}
