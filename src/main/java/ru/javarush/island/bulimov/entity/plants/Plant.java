package ru.javarush.island.bulimov.entity.plants;

import ru.javarush.island.bulimov.entity.Organism;
import ru.javarush.island.bulimov.islandMap.Cell;

public class Plant extends Organism {


    public Plant(double weight, int maxItemCell, double saturation) {
        super(weight, maxItemCell, saturation);
        this.name = "Plant";
        this.icon = "\uD83C\uDF3F";
    }

}
