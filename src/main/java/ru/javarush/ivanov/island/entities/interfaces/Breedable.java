package ru.javarush.ivanov.island.entities.interfaces;

import ru.javarush.ivanov.island.entities.territory.Square;

public interface Breedable {
    boolean breed(Square square);
}
