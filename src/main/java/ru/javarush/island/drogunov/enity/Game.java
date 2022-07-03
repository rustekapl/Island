package ru.javarush.island.drogunov.enity;

import ru.javarush.island.drogunov.enity.game_space.GameMap;
import ru.javarush.island.drogunov.view.View;

@SuppressWarnings("ClassCanBeRecord")
public class Game {

    private final GameMap gameMap;
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
