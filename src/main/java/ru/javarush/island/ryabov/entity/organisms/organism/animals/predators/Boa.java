package ru.javarush.island.ryabov.entity.organisms.organism.animals.predators;

import ru.javarush.island.ryabov.abstraction.TypeData;
import ru.javarush.island.ryabov.entity.organisms.Limit;
import ru.javarush.island.ryabov.entity.organisms.types.Predator;

@TypeData(name = "Удав", icon = "\uD83D\uDC0D", maxWeight = 15, maxCountInCell = 30, maxSpeed = 1, maxFood = 3)

public class Boa extends Predator {
    public Boa(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }
}
