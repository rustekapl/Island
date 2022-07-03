package ru.javarush.island.zazimko.entity.organizms.animals.herbivores;


import ru.javarush.island.zazimko.abstraction.annotations.TypeData;
import ru.javarush.island.zazimko.entity.organizms.Limit;

@TypeData(name = "Гусеница", icon = "\uD83D\uDC1B", maxWeight = 0.01, maxCountInCell = 1000, maxSpeed = 0, maxFood = 0)
public class Caterpillar extends Herbivore {
    public Caterpillar(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }

}
