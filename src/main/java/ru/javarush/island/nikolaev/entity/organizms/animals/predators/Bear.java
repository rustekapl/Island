package ru.javarush.island.nikolaev.entity.organizms.animals.predators;

import ru.javarush.island.nikolaev.abstraction.annotations.Setting;
import ru.javarush.island.nikolaev.entity.organizms.Limit;

@Setting(name = "Bear", icon = "\uD83D\uDC3A", maxWeight = 50, maxCount = 30, maxSpeed = 3, maxFood = 8, idFromTheSpecTable = 3)
public class Bear extends Predator {

    public Bear(String name, String icon, double weight, int idFromTheSpecTable, Limit limit) {
        super(name, icon, weight, idFromTheSpecTable, limit);
    }

}
