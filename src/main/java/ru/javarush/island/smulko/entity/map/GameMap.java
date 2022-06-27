package ru.javarush.island.smulko.entity.map;

import ru.javarush.island.smulko.entity.organizms.Organism;
import ru.javarush.island.smulko.entity.preferences.Fields;
import ru.javarush.island.smulko.entity.preferences.Preferences;
import ru.javarush.island.smulko.exception.IntiGameException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class GameMap {
    //TODO Code style. Many warnings. Skip or fix it.
    private final Cell[][] cells;

    public GameMap(int rows, int columns) {
        this.cells = new Cell[rows][columns];
    }

    public Cell[][] getCells() {
        return cells;
    }

    public int getRows() {
        return cells.length;
    }

    public int getCols() {
        return cells[0].length;
    }

    public Cell returnCellByPoints(int row, int column) {
        return cells[row][column];
    }

    public void initialize() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }
    }


    public void initializeLiveOnMap() throws CloneNotSupportedException {
        Map<Class<?>, Fields> map = Preferences.getPreferencesMap();
        Organism organism;
        for (Map.Entry<Class<?>, Fields> record : map.entrySet()) {
            int countOnCell = record.getValue().getMaxCountOnCell();
            try {
                organism = (Organism) record.getKey().getConstructors()[0].newInstance(record.getValue());
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                throw new IntiGameException("not found Entity constructor", e);
            }

            for (Cell[] cell : cells) {
                for (int j = 0; j < cell.length; j++) {
                    Set<Organism> organismSet = new HashSet<>();
                    int count = ThreadLocalRandom.current().nextInt(0, countOnCell);
                    for (int z = 0; z < count; z++) {
                        organismSet.add((Organism) organism.clone());
                    }
                    cell[j].setOrganisms(record.getKey(), organismSet);
                }
            }
        }
    }

    public void getNextCells() {
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                List<Cell> nextCells = new ArrayList<>();
                int currentRow = cell.getRow();
                int currentCol = cell.getColumn();
                int rowsLength = getRows();
                int columnsLength = getCols();
                if (currentRow - 1 >= 0) {
                    nextCells.add(cells[currentRow - 1][currentCol]);
                }
                if (currentCol - 1 >= 0) {
                    nextCells.add(cells[currentRow][currentCol - 1]);
                }
                if (currentRow + 1 < rowsLength) {
                    nextCells.add(cells[currentRow + 1][currentCol]);
                }
                if (currentCol + 1 < columnsLength) {
                    nextCells.add(cells[currentRow][currentCol + 1]);
                }
                cell.setNextCells(nextCells);
            }
        }
    }

    //FOR testing purpose, can be deleted after
    public void printNextCells() {
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                int currentRow = cell.getRow();
                int currentCol = cell.getColumn();
                System.out.print(currentRow + "," + currentCol + "=>");

                List<Cell> nextCells = cell.getNextCells();
                for (Cell nextCell : nextCells) {
                    int nextRow = nextCell.getRow();
                    int nextCol = nextCell.getColumn();
                    System.out.print(nextRow + "," + nextCol + "; ");

                }
                System.out.println();
            }
        }
    }

    public void countOrganisms() {
        Map<Type, Integer> organismQuantities = new HashMap<>();
        Map<Class<?>, Fields> preferencesMap = Preferences.getPreferencesMap();
        for (Class<?> keys : preferencesMap.keySet()) {
            organismQuantities.put(keys, 0);
        }

        for (Cell[] row : cells) {
            for (Cell cell : row) {
                Map<Type, Set<Organism>> organisms = cell.getOrganisms();
                for (Map.Entry<Type, Set<Organism>> organism : organisms.entrySet()) {
                    for (Map.Entry<Type, Integer> quantity : organismQuantities.entrySet()) {
                        if (organism.getKey().equals(quantity.getKey())) {
                            int size = organismQuantities.values().size();
                        }
                    }
                }
            }
        }
        System.out.println(organismQuantities);
    }


    public void printMap() {
        Map<String, Integer> map = new HashMap<>();
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                System.out.print("|\t");
                Map<Type, Set<Organism>> organismsMap = cell.getOrganisms();
                organismsMap.values()
                        .stream()
                        .filter(s -> s.size() > 0)
                        .forEach(s -> map.put(s.stream().findFirst().get().toString(), s.size()));
                System.out.print(map);
                System.out.print("|\t");
            }
            System.out.println();
        }
    }
}
