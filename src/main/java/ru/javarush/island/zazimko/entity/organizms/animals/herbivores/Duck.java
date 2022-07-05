package ru.javarush.island.zazimko.entity.organizms.animals.herbivores;

import ru.javarush.island.zazimko.abstraction.annotations.TypeData;
import ru.javarush.island.zazimko.entity.organizms.Limit;

@TypeData(name = "Утка", icon = "\uD83E\uDD86", maxWeight = 1, maxCountInCell = 200, maxSpeed = 4, maxFood = 0.15)
public class Duck extends Herbivore {
    public Duck(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }

}
