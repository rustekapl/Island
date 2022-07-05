package ru.javarush.island.komlev.repository;

import ru.javarush.island.komlev.etnity.map.Cell;
import ru.javarush.island.komlev.etnity.map.GameMap;

import java.util.List;

public class GameMapFactory {
    private final Factory entityFactory;

    public GameMapFactory(Factory entityFactory) {
        this.entityFactory = entityFactory;
    }

    public GameMap createFilledMap(int rows, int cols) {
        GameMap gameMap = new GameMap(rows, cols);
        Cell[][] cells = gameMap.getCells();
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                cells[row][col] = entityFactory.createRandomCell();
            }
        }
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                Cell cell = cells[row][col];
                List<Cell> nextCell = cell.getNextCell();
                if (row > 0) nextCell.add(cells[row - 1][col]);
                if (col > 0) nextCell.add(cells[row][col - 1]);
                if (row < rows - 1) nextCell.add(cells[row + 1][col]);
                if (col < cols - 1) nextCell.add(cells[row][col + 1]);
            }
        }
        return gameMap;
    }
}
