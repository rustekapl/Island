package ru.javarush.island.komlev.etnity.organizms.animals.herbivores;

import ru.javarush.island.komlev.abstraction.annotation.TypeData;
import ru.javarush.island.komlev.etnity.organizms.Limit;


@TypeData(name = "кабан", icon = "\uD83D\uDC17", maxWeight = 400, maxCount = 50, maxSpeed = 2, maxFood = 50)
public class Boar extends Herbivore {
    public Boar(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }
}


