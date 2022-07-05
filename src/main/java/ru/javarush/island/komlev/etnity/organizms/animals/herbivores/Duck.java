package ru.javarush.island.komlev.etnity.organizms.animals.herbivores;

import ru.javarush.island.komlev.abstraction.annotation.TypeData;
import ru.javarush.island.komlev.etnity.organizms.Limit;

@TypeData(name = "утка", icon = "\uD83E\uDD86", maxWeight = 1, maxCount = 200, maxSpeed = 4, maxFood = 0.15)
public class Duck extends Herbivore {
    public Duck(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }

}
