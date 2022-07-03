package ru.javarush.island.komlev.etnity.organizms.animals.predators;

import ru.javarush.island.komlev.abstraction.annotation.TypeData;
import ru.javarush.island.komlev.etnity.organizms.Limit;


@TypeData(name = "медведь", icon = "\uD83D\uDC3B", maxWeight = 500, maxCount = 5, maxSpeed = 2, maxFood = 80)
public class Bear extends Predator {
    public Bear(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }
}

