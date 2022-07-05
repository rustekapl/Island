package ru.javarush.island.ryabov.entity.organisms.organism.animals.herbivores;

import ru.javarush.island.ryabov.abstraction.TypeData;
import ru.javarush.island.ryabov.entity.organisms.Limit;
import ru.javarush.island.ryabov.entity.organisms.types.Herbivore;

@TypeData(name = "Буйвол", icon = "\uD83D\uDC03", maxWeight = 700, maxCountInCell = 10, maxSpeed = 3, maxFood = 100)
public class Buffalo extends Herbivore {
    public Buffalo(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }
}
