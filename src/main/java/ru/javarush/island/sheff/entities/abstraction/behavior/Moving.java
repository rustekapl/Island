package ru.javarush.island.sheff.entities.abstraction.behavior;

import ru.javarush.island.sheff.entities.map.Cell;

import java.util.List;

public interface Moving {

    void selectOfDirection(List<Cell> cells);
}
