package ru.javarush.island.zazimko.entity.organizms.animals.herbivores;

import ru.javarush.island.zazimko.abstraction.annotations.TypeData;
import ru.javarush.island.zazimko.entity.organizms.Limit;

@TypeData(name = "Лошадь", icon = "\uD83D\uDC0E", maxWeight = 400, maxCountInCell = 20, flockSize = 10, maxSpeed = 4, maxFood = 60)
public class Horse extends Herbivore {
    public Horse(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }

}
