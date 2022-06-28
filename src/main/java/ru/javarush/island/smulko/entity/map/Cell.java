package ru.javarush.island.smulko.entity.map;

import ru.javarush.island.smulko.entity.organizms.Organism;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Cell {
    //TODO Code style. Many warnings. Skip or fix it.
    private final int row;
    private final int column;
    private List<Cell> nextCells;
    private Map<Type, Set<Organism>> organisms = new HashMap<>();

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public List<Cell> getNextCells() {
        return nextCells;
    }

    public void setNextCells(List<Cell> nextCells) {
        this.nextCells = nextCells;
    }

    public Cell getLastCell(int steps) {
        Cell current = this;
        for (int i = 0; i < steps; i++) {
            List<Cell> nextCells = current.getNextCells();
            int direction = ThreadLocalRandom.current().nextInt(0, nextCells.size() - 1);
            current = nextCells.get(direction);
        }
        return current;
    }

    public void removeOrganismFromSet(Type type, Organism organism) {
        Set<Organism> organismSet = this.organisms.get(type); //TODO need remove animal from set, standard "remove" cause issue.
        //organismSet.remove(organism);

    }

    public void addOrganismToSet(Type type, Organism organism) {
        Set<Organism> organismSet = this.organisms.get(type);
        organismSet.add(organism);
    }

    public Map<Type, Set<Organism>> getOrganisms() {
        return organisms;
    }

    public void setOrganisms(Type type, Set<Organism> organisms) {
        this.organisms.put(type, organisms);
    }

    @Override
    public String toString() {
        return organisms.toString();
    }
}
