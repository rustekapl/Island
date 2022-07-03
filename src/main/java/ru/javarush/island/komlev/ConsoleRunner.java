package ru.javarush.island.komlev;


import ru.javarush.island.komlev.etnity.Game;
import ru.javarush.island.komlev.etnity.map.GameMap;
import ru.javarush.island.komlev.repository.EntityFactory;
import ru.javarush.island.komlev.repository.GameMapFactory;
import ru.javarush.island.komlev.services.GameWorker;
import ru.javarush.island.komlev.view.ConsVisual;
import ru.javarush.island.komlev.view.View;

public class ConsoleRunner {
    public static void main(String[] args) {
        EntityFactory entityFactory = new EntityFactory();
        GameMapFactory gameMapFactory = new GameMapFactory(entityFactory);
        GameMap gameMap = gameMapFactory.createFilledMap(5, 10);
        View view = new ConsVisual(gameMap);
        Game game = new Game(gameMap, entityFactory, view);
        GameWorker gameWorker = new GameWorker(game);
        gameWorker.start();
    }
}
