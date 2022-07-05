package ru.javarush.island.komlev.etnity.organizms.animals.herbivores;

import ru.javarush.island.komlev.abstraction.annotation.TypeData;
import ru.javarush.island.komlev.etnity.organizms.Limit;

@TypeData(name = "мышь", icon = "\uD83D\uDC01", maxWeight = 0.5, maxCount = 500, maxSpeed = 1, maxFood = 0.01)
public class Mouse extends Herbivore {
    public Mouse(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }
}
