package ru.javarush.island.bulimov.entity.animals.herbivores;

public class Boar extends Herbivore{
    public Boar(double weight, int maxItemCell, int maxSpeedInCell, double maxSaturation, double saturation) {
        super(weight, maxItemCell, maxSpeedInCell, maxSaturation, saturation);
        this.name = "Boar";
        this.icon = "\uD83D\uDC17";
    }
}
