package ru.javarush.island.hozhasaitov.app.util;

import ru.javarush.island.hozhasaitov.app.entity.eukaryotes.Eukaryote;
import ru.javarush.island.hozhasaitov.app.entity.map.Cell;

import java.util.Set;

public class AppendEukaryotesToSet {
    private AppendEukaryotesToSet() {
    }

    public static void append(Cell[] line, Set<Eukaryote> eukaryotes) {
        for (Cell cell : line) {
            eukaryotes.addAll(cell.getPredatoryAnimals());
            eukaryotes.addAll(cell.getHerbivorousAnimals());
            eukaryotes.addAll(cell.getPlants());
        }
    }
}
