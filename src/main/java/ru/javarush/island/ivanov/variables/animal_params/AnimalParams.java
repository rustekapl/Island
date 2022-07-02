package ru.javarush.island.ivanov.variables.animal_params;

public class AnimalParams {
    private double weight;
    private int maxNumberPerSquare;
    private int speed;
    private double amountOfFoodForSatiety;
    private int turnsBeforeCreatureDied = 2;

    public AnimalParams() {
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getMaxNumberPerSquare() {
        return maxNumberPerSquare;
    }

    public void setMaxNumberPerSquare(int maxNumberPerSquare) {
        this.maxNumberPerSquare = maxNumberPerSquare;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getAmountOfFoodForSatiety() {
        return amountOfFoodForSatiety;
    }

    public void setAmountOfFoodForSatiety(double amountOfFoodForSatiety) {
        this.amountOfFoodForSatiety = amountOfFoodForSatiety;
    }

    public int getTurnsBeforeCreatureDied() {
        return turnsBeforeCreatureDied;
    }

    public void setTurnsBeforeCreatureDied(int turnsBeforeCreatureDied) {
        this.turnsBeforeCreatureDied = turnsBeforeCreatureDied;
    }
}
