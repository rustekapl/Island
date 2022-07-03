package ru.javarush.island.khryukin;

import ru.javarush.island.khryukin.entity.Game;
import ru.javarush.island.khryukin.entity.map.GameMap;
import ru.javarush.island.khryukin.factory.EntityFactory;
import ru.javarush.island.khryukin.factory.Factory;
import ru.javarush.island.khryukin.factory.GameMapCreator;
import ru.javarush.island.khryukin.property.Setting;
import ru.javarush.island.khryukin.services.GameWorker;
import ru.javarush.island.khryukin.view.ConsoleView;
import ru.javarush.island.khryukin.view.View;


public class ConsoleRunner {

    public static void main(String[] args) {
        Factory entityFactory = new EntityFactory();
        GameMapCreator gameMapCreator = new GameMapCreator(entityFactory);
        GameMap gameMap = gameMapCreator.createRandomFilledGameMap(Setting.MAP_ROWS, Setting.MAP_COLS);
        View view = new ConsoleView(gameMap);
        Game game = new Game(gameMap, entityFactory, view);
        GameWorker gameWorker = new GameWorker(game);
        gameWorker.start();
    }
}
