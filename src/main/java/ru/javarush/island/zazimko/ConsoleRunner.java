package ru.javarush.island.zazimko;

import ru.javarush.island.zazimko.config.Setting;
import ru.javarush.island.zazimko.entity.Game;
import ru.javarush.island.zazimko.entity.map.GameMap;
import ru.javarush.island.zazimko.repository.AnimalFactory;
import ru.javarush.island.zazimko.repository.Factory;
import ru.javarush.island.zazimko.repository.GameMapCreator;
import ru.javarush.island.zazimko.services.GameWorker;
import ru.javarush.island.zazimko.view.ConsoleView;
import ru.javarush.island.zazimko.view.View;

public class ConsoleRunner {
    public static void main(String[] args) {
        Factory entityFactory = new AnimalFactory();
        GameMapCreator gameMapCreator = new GameMapCreator(entityFactory);
        int rows = Setting.get().getRows();
        int cols = Setting.get().getCols();
        GameMap gameMap = gameMapCreator.createRandomFilledGameMap(rows, cols, false);
        View view = new ConsoleView(gameMap);
        Game game = new Game(gameMap, entityFactory, view);
        GameWorker gameWorker = new GameWorker(game);
        gameWorker.start();
    }
}
