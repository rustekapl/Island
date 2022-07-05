package ru.javarush.island.ryabov.entity.organisms.organism.animals.predators;

import ru.javarush.island.ryabov.abstraction.TypeData;
import ru.javarush.island.ryabov.entity.organisms.Limit;
import ru.javarush.island.ryabov.entity.organisms.types.Predator;

@TypeData(name = "Медведь", icon = "\uD83D\uDC3B", maxWeight = 500, maxCountInCell = 5, maxSpeed = 2, maxFood = 80)

public class Bear extends Predator {
    public Bear(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }
}
