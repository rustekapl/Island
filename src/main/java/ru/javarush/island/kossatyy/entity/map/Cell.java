package ru.javarush.island.kossatyy.entity.map;

import lombok.Getter;
import ru.javarush.island.kossatyy.entity.creatures.Creature;
import ru.javarush.island.kossatyy.settings.Config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


@Getter
public class Cell {


    private final Lock lock = new ReentrantLock(true);
    private final int row;
    private final int column;

    private List<Cell> neighbours;

    private final Map<Integer, Set<Creature>> residents;

    private final Config config;

    public Cell(int row, int column, Config config) {
        this.residents = new HashMap<>();
        this.config = config;
        this.row = row;
        this.column = column;
    }

    public void setNeighbours(List<Cell> neighbours) {
        this.neighbours = neighbours;
    }

    @Override
    public String toString() {
        return "Cell[" + row + "]" + "[" + column + "]";
    }
}
