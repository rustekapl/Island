package ru.javarush.island.khryukin.factory;

import ru.javarush.island.khryukin.entity.animals.organisms.Organism;
import ru.javarush.island.khryukin.entity.map.Cell;

import java.util.List;

public interface Factory {
    Cell createRandomCell();

    List<Organism> getAllPrototypes();
}
