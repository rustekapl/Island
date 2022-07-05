package ru.javarush.island.komlev.etnity.organizms.animals.herbivores;

import ru.javarush.island.komlev.abstraction.annotation.TypeData;
import ru.javarush.island.komlev.etnity.organizms.Limit;

@TypeData(name = "буйвол", icon = "\uD83D\uDC03", maxWeight = 700, maxCount = 10, maxSpeed = 3, maxFood = 100)
public class Buffalo extends Herbivore {
    public Buffalo(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }
}


