package ru.javarush.island.ryabov.entity.organisms.organism.animals.herbivores;

import ru.javarush.island.ryabov.abstraction.TypeData;
import ru.javarush.island.ryabov.entity.organisms.Limit;
import ru.javarush.island.ryabov.entity.organisms.types.Herbivore;

@TypeData(name = "Кролик", icon = "\uD83D\uDC07", maxWeight = 2, maxCountInCell = 150, maxSpeed = 2, maxFood = 0.45)

public class Rabbit extends Herbivore {
    public Rabbit(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }
}
