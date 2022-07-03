package ru.javarush.island.zazimko.entity.organizms.animals.predators;

import ru.javarush.island.zazimko.abstraction.annotations.TypeData;
import ru.javarush.island.zazimko.entity.organizms.Limit;

@TypeData(name = "Лиса", icon = "\uD83E\uDD8A", maxWeight = 8, maxCountInCell = 30, maxSpeed = 2, maxFood = 2)
public class Fox extends Predator {


    public Fox(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }

}
