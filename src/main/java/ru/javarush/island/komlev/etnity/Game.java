package ru.javarush.island.komlev.etnity;

import ru.javarush.island.komlev.etnity.map.GameMap;
import ru.javarush.island.komlev.repository.Factory;
import ru.javarush.island.komlev.view.View;

public class Game {
    private final GameMap gameMap;
    private final Factory entityFactory;
    private final View view;

    public Game(GameMap gameMap, Factory entityFactory, View view) {
        this.gameMap = gameMap;
        this.entityFactory = entityFactory;
        this.view = view;

    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public Factory getEntityFactory() {
        return entityFactory;
    }

    public View getView() {
        return view;
    }
}
