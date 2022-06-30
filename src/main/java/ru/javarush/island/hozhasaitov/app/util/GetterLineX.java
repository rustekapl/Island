package ru.javarush.island.hozhasaitov.app.util;

import ru.javarush.island.hozhasaitov.app.entity.eukaryotes.animals.Animal;
import ru.javarush.island.hozhasaitov.app.entity.map.Cell;

import java.util.Arrays;

public class GetterLineX {
    private GetterLineX() {
    }

    public static Cell[] getLine(Animal animal, Cell[][] gameMap) {
        int coorX = animal.getCoorX();
        int coorY = animal.getCoorY();
        int off = Math.max(coorX - animal.getSpeed(), 0);
        int to = Math.min(coorX + animal.getSpeed() + 1, gameMap[coorY].length);
        return Arrays.copyOfRange(gameMap[coorY], off, to);

    }
}
