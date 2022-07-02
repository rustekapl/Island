package ru.javarush.island.ivanov.entities.interfaces;

import ru.javarush.island.ivanov.entities.territory.Square;

public interface Movable {
    boolean move(Square square);
}
