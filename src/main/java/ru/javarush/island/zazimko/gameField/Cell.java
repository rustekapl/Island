package ru.javarush.island.zazimko.gameField;

import lombok.Getter;
import lombok.Setter;
import ru.javarush.island.zazimko.classes.animals.Organism;
import ru.javarush.island.zazimko.classes.util.Randoms;
import ru.javarush.island.zazimko.modificators.Config;
import ru.javarush.island.zazimko.modificators.Status;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

@Setter
@Getter
public class Cell {
    private final ConcurrentHashMap<Type, Set<Organism>> organisms;
    private final ArrayList<Cell> neighbors;
    private Status status;
    private final Lock lock = new ReentrantLock(true);

    public Cell() {
        organisms = new ConcurrentHashMap<>();
        neighbors = new ArrayList<>();
        status = Status.NONE;

    }

    public void addNeighbors(Cell cell) {
        neighbors.add(cell);
    }

    public void setOrganisms(ConcurrentHashMap<Type, Set<Organism>> animals) {
        if (animals.size() > 0) {
            status = Status.LIVING;
            this.organisms.putAll(animals);
        }

    }

    public String toString() {
        return getOrganisms().values().stream()
                .filter((list) -> list.size() > 0)
                .sorted((o1, o2) -> o2.size() - o1.size())
                .map(set -> set
                        .stream()
                        .findAny()
                        .map(Organism::getLetter)
                        .orElse("?"))
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    public void updateNextCell(Field field, int row, int col) {
        Cell[][] cells = field.getCells();
        if (row > 0) neighbors.add(cells[row - 1][col]);
        if (col > 0) neighbors.add(cells[row][col - 1]);
        if (row < Config.WIDTH - 1) neighbors.add(cells[row + 1][col]);
        if (col < Config.HEIGHT - 1) neighbors.add(cells[row][col + 1]);
    }

    public Cell getNextCell(int countStep) {
        Set<Cell> visitedCells = new HashSet<>();
        Cell currentCell = this;
        while (visitedCells.size() < countStep) {
            var nextCells = currentCell
                    .neighbors
                    .stream()
                    .filter(cell -> !visitedCells.contains(cell))
                    .toList();
            int countDirections = nextCells.size();
            if (countDirections > 0) {
                int index = Randoms.getRnd(0, countDirections);
                currentCell = nextCells.get(nextCells.size() - 1 - index);
                visitedCells.add(currentCell);
            } else {
                break;
            }
        }
        return currentCell;
    }

    public int getNextCellCount() {
        return neighbors.size();
    }
}
