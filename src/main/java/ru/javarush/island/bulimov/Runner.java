package ru.javarush.island.bulimov;

import ru.javarush.island.bulimov.services.GameWorker;

public class Runner {
    public static void main(String[] args) {
        GameWorker gameWorker = new GameWorker();
        gameWorker.start();
    }
}
