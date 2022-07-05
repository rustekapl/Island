package ru.javarush.island.nikolaev.entity.organizms.animals.herbivores;

import ru.javarush.island.nikolaev.abstraction.annotations.Setting;
import ru.javarush.island.nikolaev.entity.organizms.Limit;

@Setting(name = "Goat", icon = "\uD83D\uDC10", maxWeight = 60, maxCount = 140, maxSpeed = 3, maxFood = 10, idFromTheSpecTable = 9)

public class Goat extends Herbivore {

    public Goat(String name, String icon, double weight, int idFromTheSpecTable, Limit limit) {
        super(name, icon, weight, idFromTheSpecTable, limit);
    }

}
