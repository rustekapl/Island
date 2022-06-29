package ru.javarush.ivanov.island.entities.interfaces;

import ru.javarush.ivanov.island.entities.territory.Square;

public interface Eatable {
    boolean eat(Square square);
}
