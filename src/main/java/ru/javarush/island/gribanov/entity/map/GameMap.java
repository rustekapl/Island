package ru.javarush.island.gribanov.entity.map;

public class GameMap {
    public final int HEIGHT;
    public final int WIDTH;

    private final Cell[][] cells;

    public GameMap(int HEIGHT, int WIDTH) {
        this.HEIGHT = HEIGHT;
        this.WIDTH = WIDTH;

        cells = new Cell[HEIGHT][WIDTH];
    }

    public Cell[][] getCells() {
        return cells;
    }
}
