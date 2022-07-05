package ru.javarush.island.ryabov.entity.organisms.organism.animals.herbivores;

import ru.javarush.island.ryabov.abstraction.TypeData;
import ru.javarush.island.ryabov.entity.organisms.Limit;
import ru.javarush.island.ryabov.entity.organisms.types.Herbivore;

@TypeData(name = "Овца", icon = "\uD83D\uDC11", maxWeight = 70, maxCountInCell = 140, maxSpeed = 3, maxFood = 15)

public class Sheep extends Herbivore {
    public Sheep(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }
}
