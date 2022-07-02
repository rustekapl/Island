package ru.javarush.island.hozhasaitov.app.entity.map;

import ru.javarush.island.hozhasaitov.app.entity.eukaryotes.Eukaryote;
import ru.javarush.island.hozhasaitov.app.util.ConfigClass;

public enum GameMap {
    GAME_MAP;

    //TODO ---  static bad practice
    private static Cell[][] cells = new Cell[ConfigClass.CONFIG_CLASS.getSizeYfield()]
            [ConfigClass.CONFIG_CLASS.getSizeXfield()];

    GameMap() {
    }

    public Cell[][] getMap() {
        return cells;
    }

    public void addEukaryote(Eukaryote eukaryote, int x, int y) {
        cells[y][x].addEukaryote(eukaryote);
        eukaryote.setCoorY(y);
        eukaryote.setCoorX(x);
    }

}
