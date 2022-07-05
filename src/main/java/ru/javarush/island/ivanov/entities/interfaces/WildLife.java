package ru.javarush.island.ivanov.entities.interfaces;

import ru.javarush.island.ivanov.variables.animal_params.AnimalParams;
import ru.javarush.island.ivanov.entities.territory.Square;

public interface WildLife {

    AnimalParams getParams();

    Square getSquareInfo();

    void setSquareInfo(Square squareInfo);
}
