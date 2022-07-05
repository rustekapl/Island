package ru.javarush.island.ryabov.entity.organisms.organism.animals.predators;

import ru.javarush.island.ryabov.abstraction.TypeData;
import ru.javarush.island.ryabov.entity.organisms.Limit;
import ru.javarush.island.ryabov.entity.organisms.types.Predator;

@TypeData(name = "Волк", icon = "\uD83D\uDC3A", maxWeight = 50, maxCountInCell = 30, maxSpeed = 3, maxFood = 8)

public class Wolf extends Predator {
    public Wolf(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }
}