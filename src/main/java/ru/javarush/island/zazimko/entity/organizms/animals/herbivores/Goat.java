package ru.javarush.island.zazimko.entity.organizms.animals.herbivores;

import ru.javarush.island.zazimko.abstraction.annotations.TypeData;
import ru.javarush.island.zazimko.entity.organizms.Limit;

@TypeData(name = "Коза", icon = "\uD83D\uDC10", maxWeight = 60, maxCountInCell = 140, maxSpeed = 3, maxFood = 10)
public class Goat extends Herbivore {
    public Goat(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }

}
