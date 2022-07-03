package ru.javarush.island.drogunov.util;

import ru.javarush.island.drogunov.enity.game_space.Cell;
import ru.javarush.island.drogunov.enity.game_space.GameMap;
import ru.javarush.island.drogunov.enity.game_space.GameSettings;

public class MapFactory {
    private final Factory factory;
    private final GameSettings gameSettings;


    public MapFactory(FactoryGameUnit factoryGameUnit, GameSettings gameSettings) {
        this.factory = factoryGameUnit;
        this.gameSettings = gameSettings;
    }


    public GameMap createMapUnits() {
        GameMap gameMap = new GameMap(gameSettings);
        Cell[][] space = gameMap.getSpace();
        for (int i = 0; i < space.length; i++) {
            Cell[] cells = space[i];
            for (int j = 0; j < cells.length; j++) {
                Cell cell = factory.createCell();
                space[i][j] = cell;
            }
        }
        createLinkedCells(gameMap);
        return gameMap;
    }

    private void createLinkedCells(GameMap gameMap) {
        Cell[][] space = gameMap.getSpace();
        for (int i = 0; i < space.length; i++) {
            for (int j = 0; j < space[i].length; j++) {
                space[i][j].linkedCells(gameMap, i, j);
            }
        }
    }
}
