package ru.javarush.island.bulimov.entity.animals.herbivores;

public class Buffalo extends Herbivore{
    public Buffalo(double weight, int maxItemCell, int maxSpeedInCell, double maxSaturation, double saturation) {
        super(weight, maxItemCell, maxSpeedInCell, maxSaturation, saturation);
        this.name = "Buffalo";
        this.icon = "\uD83D\uDC03";
    }
}
