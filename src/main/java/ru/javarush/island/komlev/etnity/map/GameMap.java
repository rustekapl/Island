package ru.javarush.island.komlev.etnity.map;

public class GameMap {
    private final Cell[][] cells;

    public GameMap(int rows, int cols) {

        this.cells = new Cell[rows][cols];
    }

    public Cell[][] getCells() {
        return cells;
    }

    //возвращает количество строк
    public int getRows() {
        return cells.length;
    }

    //берет первую строчку и возвращает ее длину (количество колонок)
    public int getCols() {
        return cells[0].length;
    }

}

