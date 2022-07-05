package ru.javarush.island.nikolaev.entity.organizms.animals.herbivores;

import ru.javarush.island.nikolaev.abstraction.annotations.Setting;
import ru.javarush.island.nikolaev.entity.organizms.Limit;

@Setting(name = "Buffalo", icon = "\uD83D\uDC03", maxWeight = 500, maxCount = 5, maxSpeed = 2, maxFood = 80, idFromTheSpecTable = 12)

public class Buffalo extends Herbivore {

    public Buffalo(String name, String icon, double weight, int idFromTheSpecTable, Limit limit) {
        super(name, icon, weight, idFromTheSpecTable, limit);
    }


}
