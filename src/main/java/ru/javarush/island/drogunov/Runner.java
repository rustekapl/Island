package ru.javarush.island.drogunov;

import ru.javarush.island.drogunov.enity.Game;
import ru.javarush.island.drogunov.enity.game_space.GameMap;
import ru.javarush.island.drogunov.enity.game_space.GameSettings;
import ru.javarush.island.drogunov.services.GameWorker;
import ru.javarush.island.drogunov.util.FactoryGameUnit;
import ru.javarush.island.drogunov.util.MapFactory;
import ru.javarush.island.drogunov.view.ConsoleView;
import ru.javarush.island.drogunov.view.View;

public class Runner {
    public static void main(String[] args) {
        GameSettings gameSettings = new GameSettings();
        FactoryGameUnit factoryGameUnit = new FactoryGameUnit();
        MapFactory mapFactory = new MapFactory(factoryGameUnit, gameSettings);
        GameMap gameMap = mapFactory.createMapUnits();
        View view = new ConsoleView(gameMap);

        Game game = new Game(gameMap, view);
        GameWorker gameWorker= new GameWorker(game);
        gameWorker.start();

    }
}
