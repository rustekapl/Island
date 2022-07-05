package ru.javarush.island.nikolaev.entity.organizms.animals.herbivores;


import ru.javarush.island.nikolaev.abstraction.annotations.Setting;
import ru.javarush.island.nikolaev.entity.organizms.Limit;

@Setting(name = "Mouse", icon = "\uD83D\uDC0E", maxWeight = 0.05, maxCount = 500, maxSpeed = 1, maxFood = 0.01, idFromTheSpecTable = 8)

public class Mouse extends Herbivore {

    public <idFromtheSpecTable> Mouse(String name, String icon, double weight, int idFromTheSpecTable, Limit limit) {
        super(name, icon, weight, idFromTheSpecTable, limit);
    }

}

