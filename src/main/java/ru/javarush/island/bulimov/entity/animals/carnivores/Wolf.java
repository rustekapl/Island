package ru.javarush.island.bulimov.entity.animals.carnivores;

public class Wolf extends Carnivore{
    public Wolf(double weight, int maxItemCell, int maxSpeedInCell, double maxSaturation, double saturation) {
        super(weight, maxItemCell, maxSpeedInCell, maxSaturation, saturation);
        this.name = "Wolf";
        this.icon = "\uD83D\uDC3A";
    }
}