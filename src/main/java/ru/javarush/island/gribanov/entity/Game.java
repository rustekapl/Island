package ru.javarush.island.gribanov.entity;

import ru.javarush.island.gribanov.entity.map.GameMap;
import ru.javarush.island.gribanov.view.View;

public class Game {
    private final GameMap gameMap;

    //TODO --- Code style. Need always delete code. Not comment it.
    //private final Factory entityFactory;
    private final View view;

    public Game(GameMap gameMap, View view) {
        this.gameMap = gameMap;
        this.view = view;
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public View getView() {
        return view;
    }
}
