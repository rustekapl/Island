package ru.javarush.island.stepanov.intefaces;

import ru.javarush.island.stepanov.entities.location.LocationCell;

public interface Spawnable {
    public boolean spawn(LocationCell cell);
}
