package ru.javarush.island.ryabov.util;

import ru.javarush.island.ryabov.entity.map.Cell;
import ru.javarush.island.ryabov.entity.map.GameMap;

public class GameMapCreator {

    public GameMapCreator() {
    }

    public GameMap createMap(int rows, int cols) throws CloneNotSupportedException {
        GameMap gameMap = new GameMap(rows, cols);
        Cell[][] cells = gameMap.getCells();
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                cells[row][col] = CellCreator.createCell();
            }
        }
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                cells[row][col].updateNextCell(gameMap, row, col);
            }
        }
        return gameMap;
    }
}
