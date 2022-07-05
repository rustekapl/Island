package ru.javarush.island.nikolaev;

import ru.javarush.island.nikolaev.entity.Game;
import ru.javarush.island.nikolaev.entity.map.GameMap;
import ru.javarush.island.nikolaev.repository.EntityFactory;
import ru.javarush.island.nikolaev.repository.Factory;
import ru.javarush.island.nikolaev.repository.GameMapCreator;
import ru.javarush.island.nikolaev.services.GameWorker;
import ru.javarush.island.nikolaev.view.ConsoleView;
import ru.javarush.island.nikolaev.view.View;

public class ConsoleRunner {
    public static void main(String[] args) {
        Factory entityFactory = new EntityFactory();
        GameMapCreator gameMapCreator = new GameMapCreator(entityFactory);
        GameMap gameMap = gameMapCreator.createRandomFilledGameMap(3, 6);
        View view = new ConsoleView(gameMap);
        Game game = new Game(gameMap, entityFactory, view);
        GameWorker gameWorker = new GameWorker(game);
        gameWorker.start();
    }
}
