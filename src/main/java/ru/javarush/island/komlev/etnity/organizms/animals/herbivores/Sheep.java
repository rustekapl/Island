package ru.javarush.island.komlev.etnity.organizms.animals.herbivores;

import ru.javarush.island.komlev.abstraction.annotation.TypeData;
import ru.javarush.island.komlev.etnity.organizms.Limit;

@TypeData(name = "овца", icon = "\uD83D\uDC11", maxWeight = 70, maxCount = 140, maxSpeed = 3, maxFood = 15)
public class Sheep extends Herbivore {
    public Sheep(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }
}
