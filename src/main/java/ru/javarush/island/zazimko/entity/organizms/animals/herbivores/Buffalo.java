package ru.javarush.island.zazimko.entity.organizms.animals.herbivores;

import ru.javarush.island.zazimko.abstraction.annotations.TypeData;
import ru.javarush.island.zazimko.entity.organizms.Limit;

@TypeData(name = "Буйвол", icon = "\uD83D\uDC03", maxWeight = 700, maxCountInCell = 10, maxSpeed = 3, maxFood = 100)
public class Buffalo extends Herbivore {
    public Buffalo(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }

}
