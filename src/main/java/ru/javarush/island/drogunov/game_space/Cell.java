package ru.javarush.island.drogunov.game_space;

import ru.javarush.island.drogunov.enity.GameUnit;

import java.util.List;

public class Cell {

    //TODO Code style. Many warnings. Skip or fix it.

    List<GameUnit> gameUnitListOnCell;

    private int x;

    private int y;

    public Cell(int x, int y, GameUnit gameUnit) {
        this.x = x;
        this.y = y;
        gameUnitListOnCell.add(gameUnit);
    }


    public int[] getPosition() {
        return new int[]{x, y};
    }

    public void addCell(GameUnit gameUnit) {
        gameUnitListOnCell.add(gameUnit);
    }
}
