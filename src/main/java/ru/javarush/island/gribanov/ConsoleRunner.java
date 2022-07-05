package ru.javarush.island.gribanov;

import ru.javarush.island.gribanov.entity.Game;
import ru.javarush.island.gribanov.entity.map.GameMap;
import ru.javarush.island.gribanov.services.GameWorker;
import ru.javarush.island.gribanov.utils.MapCreator;
import ru.javarush.island.gribanov.view.ConsoleView;
import ru.javarush.island.gribanov.view.View;

public class ConsoleRunner {
    public static void main(String[] args) {
        MapCreator mapCreator = new MapCreator();
        GameMap gameMap = mapCreator.createMap();
        View view=new ConsoleView(gameMap);
        Game game = new Game(gameMap, view);
        GameWorker gameWorker = new GameWorker(game);
        gameWorker.start();
    }
}
