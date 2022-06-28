package ru.javarush.island.ivanov.entities.interfaces;

import ru.javarush.island.ivanov.entities.territory.Square;

public interface Breedable {
    boolean breed(Square square);
}
