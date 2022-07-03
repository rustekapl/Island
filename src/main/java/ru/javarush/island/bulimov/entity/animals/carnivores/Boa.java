package ru.javarush.island.bulimov.entity.animals.carnivores;

public class Boa extends Carnivore{
    public Boa(double weight, int maxItemCell, int maxSpeedInCell, double maxSaturation, double saturation) {
        super(weight, maxItemCell, maxSpeedInCell, maxSaturation, saturation);
        this.name = "Boa";
        this.icon = "\uD83D\uDC0D";
    }
}
