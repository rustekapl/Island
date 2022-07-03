package ru.javarush.island.nikolaev.entity.organizms.animals.predators;

import ru.javarush.island.nikolaev.abstraction.annotations.Setting;
import ru.javarush.island.nikolaev.entity.organizms.Limit;

@Setting(name = "Fox", icon = "\uD83E\uDD8A", maxWeight = 50, maxCount = 30, maxSpeed = 3, maxFood = 8, idFromTheSpecTable = 2)

public class Fox extends Predator {

    public Fox(String name, String icon, double weight, int idFromTheSpecTable, Limit limit) {
        super(name, icon, weight, idFromTheSpecTable, limit);
    }
}

