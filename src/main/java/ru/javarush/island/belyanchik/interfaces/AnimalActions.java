package ru.javarush.island.belyanchik.interfaces;

import ru.javarush.island.belyanchik.entity.Cell;

import java.lang.reflect.InvocationTargetException;

public interface AnimalActions {
    //** Действия организма
    void goToCell(Cell cell); //TODO --- not used?

    void eat();

    boolean die();

    void reproduct() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;

}
