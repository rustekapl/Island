package ru.javarush.island.bulimov.entity.animals.herbivores;

public class Horse extends Herbivore{
    public Horse(double weight, int maxItemCell, int maxSpeedInCell, double maxSaturation, double saturation) {
        super(weight, maxItemCell, maxSpeedInCell, maxSaturation, saturation);
        this.name = "Horse";
        this.icon = "\uD83D\uDC0E";
    }
}
