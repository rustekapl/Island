package ru.javarush.island.ryabov.entity.organisms.organism.animals.herbivores;

import ru.javarush.island.ryabov.abstraction.TypeData;
import ru.javarush.island.ryabov.entity.organisms.Limit;
import ru.javarush.island.ryabov.entity.organisms.types.Herbivore;

@TypeData(name = "Кабан", icon = "\uD83D\uDC17", maxWeight = 400, maxCountInCell = 50, maxSpeed = 2, maxFood = 50)
public class Boar extends Herbivore {
    public Boar(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }
}
