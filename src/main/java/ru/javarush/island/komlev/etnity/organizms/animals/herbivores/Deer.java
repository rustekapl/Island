package ru.javarush.island.komlev.etnity.organizms.animals.herbivores;

import ru.javarush.island.komlev.abstraction.annotation.TypeData;
import ru.javarush.island.komlev.etnity.organizms.Limit;

@TypeData(name = "олень", icon = "\uD83E\uDD8C", maxWeight = 300, maxCount = 20, maxSpeed = 4, maxFood = 50)
public class Deer extends Herbivore {
    public Deer(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }
}
