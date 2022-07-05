package ru.javarush.island.synckevich.game;

import ru.javarush.island.synckevich.entities.Entity;
import ru.javarush.island.synckevich.entities.animals.Animal;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Cell {
    private final int row;
    private final int column;
    private final List<Entity> entities;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        this.entities = new CopyOnWriteArrayList<>();
    }

    public void addEntity(Entity entity) {
        this.entities.add(entity);
    }

    public void removeEntity(Entity entity) {
        this.entities.remove(entity);
    }

    public List<Entity> getEntities() {
        return this.entities;
    }

    public List<Animal> getAnimals() {
        return this.entities.stream()
                .filter(Animal.class::isInstance)
                .map(Animal.class::cast)
                .toList();
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }
}
