package ru.javarush.island.nikolaev.repository;

import ru.javarush.island.nikolaev.entity.map.Cell;
import ru.javarush.island.nikolaev.entity.organizms.Organism;

import java.util.List;

public interface Factory {

    Cell createRandomCell();

    List<Organism> getAllPrototypes();

}
