package ru.javarush.island.hozhasaitov.app.entity.eukaryotes;

import ru.javarush.island.hozhasaitov.app.interfaces.Dieable;
import ru.javarush.island.hozhasaitov.app.interfaces.Spawnable;

import java.util.Map;

public abstract class Eukaryote implements Spawnable, Dieable {

    protected Map<Class<?>, Integer> diet;

    protected int maximumAmount;
    protected int coorX;
    protected int coorY;

    protected double weightMax;

    protected double weight;

    public double getWeight() {
        return weight;
    }

    public Eukaryote() {

    }

    public double getWeightMax() {
        return weightMax;
    }

    public Map<Class<?>, Integer> getDiet() {
        return diet;
    }

    public int getMaximumAmount() {
        return maximumAmount;
    }


    public void setCoorX(int coorX) {
        this.coorX = coorX;
    }

    public void setCoorY(int coorY) {
        this.coorY = coorY;
    }

    public int getCoorX() {
        return coorX;
    }

    public int getCoorY() {
        return coorY;
    }

//-------------ABSTRACT------------------

}
