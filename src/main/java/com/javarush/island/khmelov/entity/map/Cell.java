package com.javarush.island.khmelov.entity.map;

import com.javarush.island.khmelov.entity.organizms.Organism;
import com.javarush.island.khmelov.util.Probably;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

@Getter
@Setter
@RequiredArgsConstructor
public class Cell {

    private final Map<String, Set<Organism>> residents = new HashMap<>() {
        private void checkNull(Object key) {
            this.putIfAbsent(key.toString(), new HashSet<>());
        }

        @Override
        public Set<Organism> get(Object key) {
            checkNull(key);
            return super.get(key);
        }

        @Override
        public Set<Organism> put(String key, Set<Organism> value) {
            checkNull(key);
            return super.put(key, value);
        }
    };
    private final List<Cell> nextCell = new ArrayList<>();
    private final Lock lock = new ReentrantLock(true);

    public Cell getDestinationCell(int countStep) {
        Set<Cell> visitedCells = new HashSet<>();
        Cell currentCell = this;
        while (visitedCells.size() < countStep) {
            var nextCells = currentCell
                    .getNextCell()
                    .stream()
                    .filter(cell -> !visitedCells.contains(cell))
                    .toList();
            int countDirections = nextCells.size();
            if (countDirections > 0) {
                int index = Probably.random(0, countDirections);
                currentCell = nextCells.get(index);
                visitedCells.add(currentCell);
            } else {
                break;
            }
        }
        return currentCell;
    }

    @Override
    public String toString() {
        return getResidents().values().stream()
                .filter((list) -> list.size() > 0)
                .sorted((o1, o2) -> o2.size() - o1.size())
                .map(set -> set.stream().findAny().get().getLetter())
                .map(Object::toString)
                .collect(Collectors.joining());
    }
}

