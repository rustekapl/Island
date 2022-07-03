package ru.javarush.island.ryabov.entity.organisms.organism.animals.predators;

import ru.javarush.island.ryabov.abstraction.TypeData;
import ru.javarush.island.ryabov.entity.organisms.Limit;
import ru.javarush.island.ryabov.entity.organisms.types.Predator;

@TypeData(name = "Орел", icon = "\uD83E\uDD85", maxWeight = 6, maxCountInCell = 20, maxSpeed = 3, maxFood = 1)

public class Eagle extends Predator {
    public Eagle(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }
}
