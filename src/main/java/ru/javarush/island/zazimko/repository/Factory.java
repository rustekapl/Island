package ru.javarush.island.zazimko.repository;

import ru.javarush.island.zazimko.entity.map.Cell;
import ru.javarush.island.zazimko.entity.organizms.Organism;

import java.util.List;

public interface Factory {

    Cell createRandomCell(boolean empty);

    List<Organism> getAllPrototypes();

}
