package ru.javarush.island.aleev.cotstants;

import java.lang.reflect.Type;

public enum OrganismType implements Type {
    BEAR,
    BOA,
    EAGLE,
    FOX,
    WOLF,
    BOAR,
    BUFFALO,
    CATERPILLAR,
    DEER,
    DUCK,
    GOAT,
    HORSE,
    MOUSE,
    RABBIT,
    SHEEP,
    PLANT;


    @Override
    public String getTypeName() {
        return Type.super.getTypeName();
    }
}
