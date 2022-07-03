package ru.javarush.island.sheff.services.tasks;

import ru.javarush.island.sheff.entities.map.Cell;

import java.util.concurrent.Callable;

public abstract class Task implements Callable<Boolean> {

    protected Cell[] cells;
    @Override
    public abstract Boolean call();
}
