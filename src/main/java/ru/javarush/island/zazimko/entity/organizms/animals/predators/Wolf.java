package ru.javarush.island.zazimko.entity.organizms.animals.predators;

import ru.javarush.island.zazimko.abstraction.annotations.TypeData;
import ru.javarush.island.zazimko.entity.organizms.Limit;

@TypeData(name = "Волк", icon = "\uD83D\uDC3A", maxWeight = 50, maxCountInCell = 30, maxSpeed = 3, maxFood = 8)
public class Wolf extends Predator {


    public Wolf(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }

}
