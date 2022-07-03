package ru.javarush.island.komlev.etnity.organizms.animals.predators;

import ru.javarush.island.komlev.abstraction.annotation.TypeData;
import ru.javarush.island.komlev.etnity.organizms.Limit;


@TypeData(name = "лиса", icon = "\uD83E\uDD8A", maxWeight = 8, maxCount = 30, maxSpeed = 2, maxFood = 2)
public class Fox extends Predator {
    public Fox(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }
}

