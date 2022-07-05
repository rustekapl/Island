package ru.javarush.island.sheff;

import ru.javarush.island.sheff.entities.Game;
import ru.javarush.island.sheff.entities.map.GameMap;
import ru.javarush.island.sheff.repository.GameMapCreator;
import ru.javarush.island.sheff.repository.OrganismFactory;
import ru.javarush.island.sheff.repository.OrganismFactorySingleton;
import ru.javarush.island.sheff.repository.Settings;
import ru.javarush.island.sheff.services.GameLogicWorker;
import ru.javarush.island.sheff.services.Scheduler;
import ru.javarush.island.sheff.view.SimulatorView;

public class ConsoleRunner {

    public static void main(String[] args) {

        OrganismFactory organismFactory = OrganismFactorySingleton.INSTANCE;
        GameMapCreator gameMapCreator = new GameMapCreator(organismFactory);
        GameMap gameMap = gameMapCreator.createRandomStartGameMapFromSettings();
        SimulatorView simulatorView = new SimulatorView();
        GameLogicWorker gameLogicWorker = new GameLogicWorker(simulatorView, gameMap);
        gameLogicWorker.initialize();
        Scheduler scheduler = new Scheduler(gameLogicWorker, Settings.DURATION.getValue());
        Game game = new Game(gameMap, organismFactory, simulatorView, scheduler);
        game.startGame();
    }
}
