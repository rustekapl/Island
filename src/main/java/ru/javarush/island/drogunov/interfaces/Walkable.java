package ru.javarush.island.drogunov.interfaces;

import ru.javarush.island.drogunov.enity.game_space.Cell;
@FunctionalInterface
public interface Walkable {
    //TODO вообще не понятна данная ошибка, метод не используется в качестве лямбды?
    boolean walk(Cell current);
}

