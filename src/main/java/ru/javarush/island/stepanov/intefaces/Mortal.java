package ru.javarush.island.stepanov.intefaces;

import ru.javarush.island.stepanov.entities.location.LocationCell;

public interface Mortal {

    public void die(LocationCell cell);
}
