package ru.javarush.island.sheff.entities.map;

import lombok.Getter;
import ru.javarush.island.sheff.entities.organisms.Organism;
import ru.javarush.island.sheff.repository.OrganismTypes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Getter
public class Cell {

    private final int row;
    private final int col;

    private ConcurrentHashMap<String, HashSet<Organism>> residents;
    private ConcurrentHashMap<String, HashSet<Organism>> newResidents;
    private final List<Cell> adjacentCells = new ArrayList<>();

    public Cell(int row, int col, ConcurrentHashMap<String, HashSet<Organism>> residents, ConcurrentHashMap<String, HashSet<Organism>> newResidents) {
        this.row = row;
        this.col = col;
        this.residents = residents;
        this.newResidents = newResidents;
    }

    public void updateNextCell(GameMap map, int row, int col) {
        Cell[][] cells = map.getCells();
        if (row > 0) adjacentCells.add(cells[row - 1][col]);
        if (col > 0) adjacentCells.add(cells[row][col - 1]);
        if (row < map.getRowsLength() - 1) adjacentCells.add(cells[row + 1][col]);
        if (col < map.getColsLength() - 1) adjacentCells.add(cells[row][col + 1]);
    }

    public void updateResidents(ConcurrentHashMap<String, HashSet<Organism>> newOrganismNamesMap) {
        residents = newResidents;
        newResidents = newOrganismNamesMap;
    }

    @Override
    public String toString() {
        return "" + residents.entrySet()
                .stream()
                .filter(stringHashSetEntry -> stringHashSetEntry.getValue().size() > 0)
                .map((entry) -> OrganismTypes.valueOf(entry.getKey().toUpperCase()).getIcon()
                        + ":" + entry.getValue().size())
                .collect(Collectors.joining("\n"));
    }
}
