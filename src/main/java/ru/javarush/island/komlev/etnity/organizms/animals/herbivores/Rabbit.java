package ru.javarush.island.komlev.etnity.organizms.animals.herbivores;

import ru.javarush.island.komlev.abstraction.annotation.TypeData;
import ru.javarush.island.komlev.etnity.organizms.Limit;

@TypeData(name = "кролик", icon = "\uD83D\uDC07", maxWeight = 2, maxCount = 500, maxSpeed = 2, maxFood = 0.45)
public class Rabbit extends Herbivore {
    public Rabbit(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }
}



