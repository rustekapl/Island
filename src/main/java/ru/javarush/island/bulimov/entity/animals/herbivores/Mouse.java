package ru.javarush.island.bulimov.entity.animals.herbivores;

public class Mouse extends Herbivore{
    public Mouse(double weight, int maxItemCell, int maxSpeedInCell, double maxSaturation, double saturation) {
        super(weight, maxItemCell, maxSpeedInCell, maxSaturation, saturation);
        this.name = "Mouse";
        this.icon = "\uD83D\uDC01";
    }
}
