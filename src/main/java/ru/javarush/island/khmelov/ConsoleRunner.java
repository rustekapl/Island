package ru.javarush.island.khmelov;

import ru.javarush.island.khmelov.config.Setting;
import ru.javarush.island.khmelov.entity.Game;
import ru.javarush.island.khmelov.entity.map.GameMap;
import ru.javarush.island.khmelov.repository.EntityFactory;
import ru.javarush.island.khmelov.repository.Factory;
import ru.javarush.island.khmelov.repository.GameMapCreator;
import ru.javarush.island.khmelov.services.GameWorker;
import ru.javarush.island.khmelov.view.ConsoleView;
import ru.javarush.island.khmelov.view.View;

public class ConsoleRunner {
    public static void main(String[] args) {
        Factory entityFactory = new EntityFactory();
        GameMapCreator gameMapCreator = new GameMapCreator(entityFactory);
        int rows = Setting.get().getRows();
        int cols = Setting.get().getCols();
        GameMap gameMap = gameMapCreator.createRandomFilledGameMap(rows, cols, false);
        View view=new ConsoleView(gameMap);
        Game game = new Game(gameMap, entityFactory,view);
        GameWorker gameWorker = new GameWorker(game);
        gameWorker.start();
    }
}
