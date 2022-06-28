package ru.javarush.island.khmelov.repository;

import ru.javarush.island.khmelov.entity.map.Cell;
import ru.javarush.island.khmelov.entity.organizms.Organism;

import java.util.List;

public interface Factory {

    Cell createRandomCell(boolean empty);

    List<Organism> getAllPrototypes();

}
