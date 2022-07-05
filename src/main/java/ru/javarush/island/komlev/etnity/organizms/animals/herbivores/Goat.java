package ru.javarush.island.komlev.etnity.organizms.animals.herbivores;

import ru.javarush.island.komlev.abstraction.annotation.TypeData;
import ru.javarush.island.komlev.etnity.organizms.Limit;


@TypeData(name = "коза", icon = "\uD83D\uDC10", maxWeight = 60, maxCount = 140, maxSpeed = 3, maxFood = 10)
public class Goat extends Herbivore {
    public Goat(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }
}
