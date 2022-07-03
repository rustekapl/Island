package ru.javarush.island.komlev.etnity.organizms.animals.predators;

import ru.javarush.island.komlev.abstraction.annotation.TypeData;
import ru.javarush.island.komlev.etnity.organizms.Limit;


@TypeData(name = "удав", icon = "\uD83D\uDC0D", maxWeight = 15, maxCount = 30, maxSpeed = 1, maxFood = 3)
public class Boa extends Predator {
    public Boa(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }
}

