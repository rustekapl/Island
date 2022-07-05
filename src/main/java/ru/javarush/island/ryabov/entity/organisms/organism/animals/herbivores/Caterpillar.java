package ru.javarush.island.ryabov.entity.organisms.organism.animals.herbivores;

import ru.javarush.island.ryabov.abstraction.TypeData;
import ru.javarush.island.ryabov.entity.organisms.Limit;
import ru.javarush.island.ryabov.entity.organisms.types.Herbivore;

@TypeData(name = "Гусеница", icon = "\uD83D\uDC1B", maxWeight = 0.01, maxCountInCell = 1000, maxSpeed = 0, maxFood = 0)

public class Caterpillar extends Herbivore {
    public Caterpillar(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }
}
