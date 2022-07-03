package ru.javarush.island.bulimov.entity.animals.herbivores;

public class Caterpillar extends Herbivore{
    public Caterpillar(double weight, int maxItemCell, int maxSpeedInCell, double maxSaturation, double saturation) {
        super(weight, maxItemCell, maxSpeedInCell, maxSaturation, saturation);
        this.name = "Caterpillar";
        this.icon = "\uD83D\uDC1B";
    }
}
