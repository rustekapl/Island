package ru.javarush.island.nikolaev.entity.map;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.javarush.island.nikolaev.entity.organizms.Organism;
import ru.javarush.island.nikolaev.util.Randomizer;

import java.lang.reflect.Type;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

@Getter
@Setter
@RequiredArgsConstructor
public class Cell {

    private final Map<Type, Set<Organism>> residents;
    private final List<Cell> nextCell = new ArrayList<>();
    private final Lock lock = new ReentrantLock(true);

    @Override
    public String toString() {
        return getResidents().values().stream()
                .filter((list) -> list.size() > 0)
                .sorted((o1, o2) -> o2.size() - o1.size())
                .map(set -> set.stream().findAny().get().getClass().getSimpleName().substring(0, 1))
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    public Cell getNextCell(int countStep) {
        Set<Cell> cellsVisited = new HashSet<>();
        Cell currentCell = this;
        while (cellsVisited.size() < countStep) {
            List<Cell> nextCells = new ArrayList<>();
            for (Cell cell : currentCell
                    .nextCell) {
                nextCells.add(cell);
            }
            int countDirections = nextCells.size();
            if (countDirections > 0) {
                int index = Randomizer.random(0, countDirections);
                currentCell = nextCells.get(index);
                cellsVisited.add(currentCell);
            } else {
                break;
            }
        }
        return currentCell;
    }
}

