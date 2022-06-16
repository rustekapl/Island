package com.javarush.island.khmelov.repository;

import com.javarush.island.khmelov.entity.map.Cell;
import com.javarush.island.khmelov.entity.organizms.Organism;

public interface Factory {

    Cell createRandomCell();

    Organism[] getAllPrototypes();

}
