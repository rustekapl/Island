package ru.javarush.island.komlev.etnity.organizms.animals.predators;

import ru.javarush.island.komlev.abstraction.annotation.TypeData;
import ru.javarush.island.komlev.etnity.organizms.Limit;

@TypeData(name = "орел", icon = "\uD83E\uDD85", maxWeight = 6, maxCount = 20, maxSpeed = 3, maxFood = 1)
public class Eagle extends Predator {
    public Eagle(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }
}

