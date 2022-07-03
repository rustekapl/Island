package ru.javarush.island.bulimov.entity.animals.herbivores;

public class Goat extends Herbivore{
    public Goat(double weight, int maxItemCell, int maxSpeedInCell, double maxSaturation, double saturation) {
        super(weight, maxItemCell, maxSpeedInCell, maxSaturation, saturation);
        this.name = "Goat";
        this.icon = "\uD83D\uDC10";
    }
}
