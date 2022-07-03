package ru.javarush.island.ryabov;

import ru.javarush.island.ryabov.constants.Constants;
import ru.javarush.island.ryabov.entity.Game;
import ru.javarush.island.ryabov.entity.map.GameMap;
import ru.javarush.island.ryabov.services.GameWorker;
import ru.javarush.island.ryabov.util.CellCreator;
import ru.javarush.island.ryabov.util.Factory;
import ru.javarush.island.ryabov.util.GameMapCreator;
import ru.javarush.island.ryabov.view.ConsoleView;
import ru.javarush.island.ryabov.view.View;

public class Runner {
    public static void main(String[] args) throws CloneNotSupportedException {
        Factory cellCreator = new CellCreator();
        GameMapCreator gameMapCreator = new GameMapCreator();
        int row = Constants.ROWS;
        int col = Constants.COLS;
        GameMap gameMap = gameMapCreator.createMap(row, col);
        View view = new ConsoleView(gameMap);
        Game game = new Game(gameMap, cellCreator, view);
        GameWorker gameWorker = new GameWorker(game, gameMap);
        gameWorker.start();
    }
}