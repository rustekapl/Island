package ru.javarush.island.synckevich.game;

import ru.javarush.island.synckevich.entities.Entity;
import ru.javarush.island.synckevich.entities.EntityFactory;
import ru.javarush.island.synckevich.enums.EntityType;

public class GameField {
    private final int height;
    private final int width;
    private final Cell[][] cells;

    public GameField(int width, int height) {
        this.width = width;
        this.height = height;
        this.cells = new Cell[height][width];
    }

    public void initialize() {

        for (int y = 0; y < this.getHeight(); ++y) {

            for (int x = 0; x < this.getWidth(); ++x) {
                this.cells[y][x] = new Cell(x, y);
            }

        }

    }

    public void fill(int maxEntityCount) {

        for (int y = 0; y < this.height; ++y) {

            for (int x = 0; x < this.width; ++x) {

                for (int i = 0; i <= maxEntityCount; ++i) {
                    Entity entity = this.getRandomEntity();
                    this.cells[y][x].addEntity(entity);
                }

            }
        }

    }

    public Runnable createPlantGrowTask() {
        return () -> {
            int x = Randomizer.get(this.getWidth());
            int y = Randomizer.get(this.getHeight());
            Cell cell = this.cells[y][x];
            cell.addEntity(EntityFactory.createAnimal(EntityType.PLANT));
        };
    }

    public Cell[][] getCells() {
        return this.cells;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    private Entity getRandomEntity() {
        EntityType[] entityTypes = EntityType.values();
        int size = entityTypes.length;
        EntityType entityType = entityTypes[Randomizer.get(size)];
        return EntityFactory.createAnimal(entityType);
    }
}
