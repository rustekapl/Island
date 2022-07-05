package ru.javarush.island.zazimko.entity.organizms.animals.herbivores;


import ru.javarush.island.zazimko.abstraction.annotations.TypeData;
import ru.javarush.island.zazimko.entity.organizms.Limit;

@TypeData(name = "Мышь", icon = "\uD83D\uDC01", maxWeight = 0.05, maxCountInCell = 500, flockSize = 10, maxSpeed = 1, maxFood = 0.01)
public class Mouse extends Herbivore {
    public Mouse(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }

}
