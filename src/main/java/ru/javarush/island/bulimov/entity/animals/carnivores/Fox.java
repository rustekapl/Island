package ru.javarush.island.bulimov.entity.animals.carnivores;

public class Fox extends Carnivore{
    public Fox(double weight, int maxItemCell, int maxSpeedInCell, double maxSaturation, double saturation) {
        super(weight, maxItemCell, maxSpeedInCell, maxSaturation, saturation);
        this.name = "Fox";
        this.icon = "\uD83E\uDD8A";
    }
}
