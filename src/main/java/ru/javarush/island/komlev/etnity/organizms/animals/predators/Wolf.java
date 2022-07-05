package ru.javarush.island.komlev.etnity.organizms.animals.predators;

import ru.javarush.island.komlev.abstraction.annotation.TypeData;
import ru.javarush.island.komlev.etnity.organizms.Limit;


@TypeData(name = "волк", icon = " \uD83D\uDC3A", maxWeight = 50, maxCount = 30, maxSpeed = 3, maxFood = 8)
public class Wolf extends Predator {
    public Wolf(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }
}

