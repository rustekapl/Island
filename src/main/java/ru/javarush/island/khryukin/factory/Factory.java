package ru.javarush.island.khryukin.factory;

import ru.javarush.island.khryukin.entity.map.Cell;
import ru.javarush.island.khryukin.entity.organisms.Organism;

import java.util.List;

public interface Factory {
    Cell createRandomCell();

    List<Organism> getAllPrototypes();
}
