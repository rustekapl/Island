package ru.javarush.island.zazimko.entity.organizms.animals.herbivores;


import ru.javarush.island.zazimko.abstraction.annotations.TypeData;
import ru.javarush.island.zazimko.entity.organizms.Limit;

@TypeData(name = "Олень", icon = "\uD83E\uDD8C", maxWeight = 300, maxCountInCell = 20, maxSpeed = 4, maxFood = 50)
public class Deer extends Herbivore {
    public Deer(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }

}
