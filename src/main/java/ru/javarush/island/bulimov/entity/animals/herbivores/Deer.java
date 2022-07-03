package ru.javarush.island.bulimov.entity.animals.herbivores;

public class Deer extends Herbivore{
    public Deer(double weight, int maxItemCell, int maxSpeedInCell, double maxSaturation, double saturation) {
        super(weight, maxItemCell, maxSpeedInCell, maxSaturation, saturation);
        this.name = "Deer";
        this.icon = "\uD83E\uDD8C";
    }
}
