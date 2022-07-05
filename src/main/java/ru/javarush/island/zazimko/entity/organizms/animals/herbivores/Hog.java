package ru.javarush.island.zazimko.entity.organizms.animals.herbivores;

import ru.javarush.island.zazimko.abstraction.annotations.TypeData;
import ru.javarush.island.zazimko.entity.organizms.Limit;

@TypeData(name = "Кабан", icon = "\uD83D\uDC17", maxWeight = 400, maxCountInCell = 50, maxSpeed = 2, maxFood = 50)
public class Hog extends Herbivore {
    public Hog(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }

}
