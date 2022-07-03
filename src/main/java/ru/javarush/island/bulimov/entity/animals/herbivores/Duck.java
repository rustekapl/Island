package ru.javarush.island.bulimov.entity.animals.herbivores;

public class Duck extends Herbivore{
    public Duck(double weight, int maxItemCell, int maxSpeedInCell, double maxSaturation, double saturation) {
        super(weight, maxItemCell, maxSpeedInCell, maxSaturation, saturation);
        this.name = "Boar";
        this.icon = "\uD83E\uDD86";
    }
}
