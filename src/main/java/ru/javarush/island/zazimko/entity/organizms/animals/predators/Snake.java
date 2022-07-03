package ru.javarush.island.zazimko.entity.organizms.animals.predators;

import ru.javarush.island.zazimko.abstraction.annotations.TypeData;
import ru.javarush.island.zazimko.entity.organizms.Limit;

@TypeData(name = "Змея", icon = "\uD83D\uDC0D", maxWeight = 15, maxCountInCell = 30, flockSize = 5, maxSpeed = 1, maxFood = 3)
public class Snake extends Predator {


    public Snake(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }

}
