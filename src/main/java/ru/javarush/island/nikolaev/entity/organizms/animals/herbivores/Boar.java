package ru.javarush.island.nikolaev.entity.organizms.animals.herbivores;

import ru.javarush.island.nikolaev.abstraction.annotations.Setting;
import ru.javarush.island.nikolaev.entity.organizms.Limit;

@Setting(name = "Boar", icon = "\uD83D\uDC17", maxWeight = 400, maxCount = 50, maxSpeed = 2, maxFood = 50, idFromTheSpecTable = 11)

public class Boar extends Herbivore {

    public Boar(String name, String icon, double weight, int idFromTheSpecTable, Limit limit) {
        super(name, icon, weight, idFromTheSpecTable, limit);
    }
}
