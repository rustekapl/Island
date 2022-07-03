package ru.javarush.island.nikolaev.entity.organizms.animals.predators;

import ru.javarush.island.nikolaev.abstraction.annotations.Setting;
import ru.javarush.island.nikolaev.entity.organizms.Limit;


@Setting(name = "Eagle", icon = "\uD83E\uDD85", maxWeight = 50, maxCount = 30, maxSpeed = 3, maxFood = 8, idFromTheSpecTable = 4)

public class Eagle extends Predator {

    public Eagle(String name, String icon, double weight, int idFromTheSpecTable, Limit limit) {
        super(name, icon, weight, idFromTheSpecTable, limit);
    }
}
