package ru.javarush.island.smulko;

import ru.javarush.island.smulko.entity.map.GameMap;

public class ConsoleRunner {

    public static void main(String[] args) throws CloneNotSupportedException {
        GameMap map = new GameMap(5, 5);
        map.initialize();
        map.initializeLiveOnMap();
        map.getNextCells();
        map.printMap();

    }
}
