package ru.javarush.island.sheff.entities.map;

import ru.javarush.island.sheff.entities.organisms.Organism;
import ru.javarush.island.sheff.repository.OrganismFactory;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class GameMap {
    private final Cell[][] cells;
    private final int rows;
    private final int cols;
    private final OrganismFactory organismFactory;

    public GameMap(int rows, int cols, OrganismFactory organismFactory) {
        this.rows = rows;
        this.cols = cols;
        this.cells = new Cell[rows][cols];
        this.organismFactory = organismFactory;
    }

    public void initialize() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                cells[row][col] = new Cell(row, col, organismFactory.getNewOrganismNamesMap(), organismFactory.getNewOrganismNamesMap());
            }
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                cells[row][col].updateNextCell(this, row, col);
            }
        }
    }

    public void updateCells() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                cells[row][col].updateResidents(organismFactory.getNewOrganismNamesMap());
            }
        }
    }

    public int getTransferCount() {
        return getAllOrganismsSet()
                .stream()
                .collect(Collectors.summarizingInt(value -> value.getLimit().getMaxSpeed())).getMax();
    }

    public Cell[][] getCells() {
        return cells;
    }

    public int getRowsLength() {
        return cells.length;
    }

    public int getColsLength() {
        return cells[0].length;
    }

    public ConcurrentMap<Integer, HashSet<Organism>> getAllOrganismsMap() {
        ConcurrentMap<Integer, HashSet<Organism>> allOrganisms = new ConcurrentHashMap<>();

        for (int i = 0; i < rows; i++) {
            allOrganisms.put(i, new HashSet<>());
        }

        for (int i = 0; i < rows; i++) {
            Cell[] cell = cells[i];
            for (int j = 0; j < cols; j++) {
                //TODO ---  name cell1???
                Cell cell1 = cell[j];
                cell1.getResidents()
                        .values()
                        .stream()
                        .flatMap(Collection::stream)
                        .forEach(organism -> allOrganisms.get(organism.getLocation().getRow()).add(organism));
            }
        }
        return allOrganisms;
    }

    public Set<Organism> getAllOrganismsSet() {
        Set<Organism> allOrganisms = new HashSet<>();
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                allOrganisms.addAll(cell.getResidents()
                        .values()
                        .stream()
                        .flatMap(Collection::stream)
                        .collect(Collectors.toSet()));
            }
        }
        return allOrganisms;
    }
}
