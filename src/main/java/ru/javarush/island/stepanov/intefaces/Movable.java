package ru.javarush.island.stepanov.intefaces;

import ru.javarush.island.stepanov.entities.location.Location;
import ru.javarush.island.stepanov.entities.location.LocationCell;

public interface Movable {

    public void move(LocationCell cell, Location location);

}
