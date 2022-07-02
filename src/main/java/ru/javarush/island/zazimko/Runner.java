package ru.javarush.island.zazimko;

import ru.javarush.island.zazimko.classes.Game;
import ru.javarush.island.zazimko.classes.util.Factory;
import ru.javarush.island.zazimko.gameField.Field;
import ru.javarush.island.zazimko.services.GameWorker;
import ru.javarush.island.zazimko.view.ConsoleView;
import ru.javarush.island.zazimko.view.View;

public class Runner {

    public static void main(String[] args) {
        Factory factory = new Factory();
        Field field = new Field();
        View view = new ConsoleView(field);
        Game game = new Game(factory, view, field);
        GameWorker gameWorker = new GameWorker(game);
        gameWorker.start();
    }
}
