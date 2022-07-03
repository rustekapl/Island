package ru.javarush.island.bulimov.entity.animals.herbivores;

public class Sheep extends Herbivore{
    public Sheep(double weight, int maxItemCell, int maxSpeedInCell, double maxSaturation, double saturation) {
        super(weight, maxItemCell, maxSpeedInCell, maxSaturation, saturation);
        this.name = "Sheep";
        this.icon = "\uD83D\uDC11";
    }
}
