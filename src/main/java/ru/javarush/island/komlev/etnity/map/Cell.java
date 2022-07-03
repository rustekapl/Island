package ru.javarush.island.komlev.etnity.map;

import ru.javarush.island.komlev.etnity.organizms.Organism;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;


public class Cell {
    private final Map<Type, Set<Organism>> residents;
    private List<Cell> nextCell;
    private final Lock lock = new ReentrantLock(true);

    public Cell(Map<Type, Set<Organism>> residents) {
        this.residents = residents;
    }


    public Map<Type, Set<Organism>> getResidents() {
        return residents;
    }

    public List<Cell> getNextCell() {
        return nextCell;
    }

    public void setNextCell(List<Cell> nextCell) {
        this.nextCell = nextCell;
    }

    public Lock getLock() {
        return lock;
    }

    @Override
    public String toString() {
        return getResidents().values().stream()
                //выкинули пустые элементы карты
                .filter((list) -> list.size() > 0)
                //отсортировали оставшихся животных по размеру
                .sorted((o1, o2) -> o2.size() - o1.size())
                .limit(3)
                //среди всех волков нашли первого попавшегося (Any),
                // вытащили как он называется, вытащили простое имя этого класса,
                // и вытащили первую букву этого класса
                .map(set -> set.stream().findAny().get().getClass().getSimpleName().substring(0, 1))
                .map(Object::toString)
                .collect(Collectors.joining());
    }
}
