package ru.javarush.island.khmelov.entity.map;

import lombok.Getter;
import ru.javarush.island.khmelov.entity.organizms.Organism;
import ru.javarush.island.khmelov.entity.organizms.Organisms;
import ru.javarush.island.khmelov.util.Rnd;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class Cell {

    private static final int PERCENT_RANDOM_ROTATE = 5;
    private final List<Cell> nextCell = new ArrayList<>();
    @Getter
    private final Lock lock = new ReentrantLock(true);
    @Getter
    private final Map<String, Organisms> residents = new HashMap<>() {
        private void checkNull(Object key) {
            this.putIfAbsent(key.toString(), new Organisms());
        }

        @Override
        public Organisms get(Object key) {
            checkNull(key);
            return super.get(key);
        }

        @Override
        public Organisms put(String key, Organisms value) {
            checkNull(key);
            return super.put(key, value);
        }
    };

    public void randomeRotateResidents() {
        if (residents.size() > 1 && Rnd.get(PERCENT_RANDOM_ROTATE)) {
            Set<Map.Entry<String, Organisms>> entrySet = residents.entrySet();
            var iterator = entrySet.iterator();
            var organisms = iterator.next();
            iterator.remove();
            residents.put(organisms.getKey(), organisms.getValue());
        }
    }

    public void updateNextCell(GameMap map, int row, int col) {
        Cell[][] cells = map.getCells();
        if (row > 0) nextCell.add(cells[row - 1][col]);
        if (col > 0) nextCell.add(cells[row][col - 1]);
        if (row < map.getRows() - 1) nextCell.add(cells[row + 1][col]);
        if (col < map.getCols() - 1) nextCell.add(cells[row][col + 1]);
    }

    public Cell getNextCell(int countStep) {
        Set<Cell> visitedCells = new HashSet<>();
        Cell currentCell = this;
        while (visitedCells.size() < countStep) {
            var nextCells = currentCell
                    .nextCell
                    .stream()
                    .filter(cell -> !visitedCells.contains(cell))
                    .toList();
            int countDirections = nextCells.size();
            if (countDirections > 0) {
                int index = Rnd.random(0, countDirections);
                currentCell = nextCells.get(nextCells.size() - 1 - index);
                visitedCells.add(currentCell);
            } else {
                break;
            }
        }
        return currentCell;
    }

    public int getNextCellCount() {
        return nextCell.size();
    }

    @Override
    public String toString() {
        return getResidents().values().stream()
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
}

