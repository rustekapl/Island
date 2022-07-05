package ru.javarush.island.komlev.etnity.organizms.animals.herbivores;

import ru.javarush.island.komlev.abstraction.annotation.TypeData;
import ru.javarush.island.komlev.etnity.organizms.Limit;


@TypeData(name = "гусеница", icon = "\uD83D\uDC11", maxWeight = 0.01, maxCount = 1000, maxSpeed = 0, maxFood = 0)
public class Caterpillar extends Herbivore {
    public Caterpillar(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }
}
