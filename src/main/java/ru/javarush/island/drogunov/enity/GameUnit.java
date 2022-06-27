package ru.javarush.island.drogunov.enity;

import ru.javarush.island.drogunov.game_space.Cell;
import ru.javarush.island.drogunov.game_space.GameSpace;

public abstract class GameUnit {
    GameSpace gameSpace = GameSpace.getInstance();
    Cell position;

    public GameUnit(int x, int y) {
        if (gameSpace.getCell(x, y) == null) {
            this.position = new Cell(x, y, this);
        } else {
            gameSpace.getCell(x, y).addCell(this);
        }
    }
}
