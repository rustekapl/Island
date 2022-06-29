package ru.javarush.ivanov.island.entities.interfaces;

import ru.javarush.ivanov.island.entities.territory.Square;
import ru.javarush.ivanov.island.variables.animal_params.AnimalParams;

public interface WildLife {

    AnimalParams getParams();

    Square getSquareInfo();

    void setSquareInfo(Square squareInfo);
}
