package ru.javarush.island.bityutskih.entity;

public interface Nature {
    int getobjPerService();

    void setDead();

    float getWeight();

    boolean isDead();

    Nature getInstance();

    String toString();
}
