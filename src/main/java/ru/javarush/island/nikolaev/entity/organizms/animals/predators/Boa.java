package ru.javarush.island.nikolaev.entity.organizms.animals.predators;

import ru.javarush.island.nikolaev.abstraction.annotations.Setting;
import ru.javarush.island.nikolaev.entity.organizms.Limit;


@Setting(name = "Boa", icon = "\uD83D\uDC0D", maxWeight = 50, maxCount = 30, maxSpeed = 3, maxFood = 8, idFromTheSpecTable = 1)

public class Boa extends Predator {

    public Boa(String name, String icon, double weight, int idFromTheSpecTable, Limit limit) {
        super(name, icon, weight, idFromTheSpecTable, limit);
    }
}

