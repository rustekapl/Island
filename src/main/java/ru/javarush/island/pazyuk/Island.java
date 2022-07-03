package ru.javarush.island.pazyuk;

import ru.javarush.island.pazyuk.Entity.Entity;

import java.util.ArrayList;
import java.util.HashMap;

public class Island {
    private static Island island;
    private final int WIDTH;
    private final int HEIGHT;
    private HashMap<Class<? extends Entity>, ArrayList<Entity>>[][] cells;

    private Island(int width, int height) {
        WIDTH = width;
        HEIGHT = height;
        cells = new HashMap[width][height];
    }

    public static Island getIsland() {
        if (island == null) {
            island = new Island(9, 9);
        }
        return island;
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }

    public HashMap<Class<? extends Entity>, ArrayList<Entity>>[][] getCells() {
        return cells;
    }
}
