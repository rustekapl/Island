package ru.javarush.island.ryabov.entity.organisms.organism.animals.herbivores;

import ru.javarush.island.ryabov.abstraction.TypeData;
import ru.javarush.island.ryabov.entity.organisms.Limit;
import ru.javarush.island.ryabov.entity.organisms.types.Herbivore;

@TypeData(name = "Мышь", icon = "\uD83D\uDC01", maxWeight = 0.05, maxCountInCell = 500, maxSpeed = 1, maxFood = 0.01)

public class Mouse extends Herbivore {
    public Mouse(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }
}
