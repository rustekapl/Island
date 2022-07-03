package ru.javarush.island.nikolaev.entity.organizms.animals.herbivores;

import ru.javarush.island.nikolaev.abstraction.annotations.Setting;
import ru.javarush.island.nikolaev.entity.organizms.Limit;

@Setting(name = "Duck", icon = "\uD83D\uDC03", maxWeight = 300, maxCount = 20, maxSpeed = 4, maxFood = 50, idFromTheSpecTable = 12)

public class Duck extends Herbivore {

    public Duck(String name, String icon, double weight, int idFromTheSpecTable, Limit limit) {
        super(name, icon, weight, idFromTheSpecTable, limit);
    }
}
