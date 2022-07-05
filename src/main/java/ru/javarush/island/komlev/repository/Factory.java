package ru.javarush.island.komlev.repository;

import ru.javarush.island.komlev.etnity.map.Cell;
import ru.javarush.island.komlev.etnity.organizms.Organism;

import java.util.List;

public interface Factory {
    Cell createRandomCell();

    List<Organism> getAllPrototypes();
}
