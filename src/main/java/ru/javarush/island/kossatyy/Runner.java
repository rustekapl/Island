package ru.javarush.island.kossatyy;

import ru.javarush.island.kossatyy.entity.Game;
import ru.javarush.island.kossatyy.entity.map.Island;
import ru.javarush.island.kossatyy.entity.repository.EntityFactory;
import ru.javarush.island.kossatyy.entity.repository.Factory;
import ru.javarush.island.kossatyy.services.GameWorker;
import ru.javarush.island.kossatyy.settings.Config;
import ru.javarush.island.kossatyy.view.ConsoleView;
import ru.javarush.island.kossatyy.view.View;


public class Runner {
    public static void main(String[] args) {
        Config config = Config.getConfig();

        Island island = new Island(config);

        island.initialize(); // TODO почитать тему дизайны проектирования (injection)

        View view = new ConsoleView(island);
        Factory entityFactory = new EntityFactory();
        Game game = new Game(island, entityFactory, view);
        GameWorker gameWorker = new GameWorker(game);
        gameWorker.start();


    }
}
