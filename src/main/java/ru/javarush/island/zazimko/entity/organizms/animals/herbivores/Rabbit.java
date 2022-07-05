package ru.javarush.island.zazimko.entity.organizms.animals.herbivores;


import ru.javarush.island.zazimko.abstraction.annotations.TypeData;
import ru.javarush.island.zazimko.entity.organizms.Limit;

@TypeData(name = "Кролик", icon = "\uD83D\uDC07", maxWeight = 2, maxCountInCell = 150, maxSpeed = 2, maxFood = 0.45)
public class Rabbit extends Herbivore {
    public Rabbit(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }

}
