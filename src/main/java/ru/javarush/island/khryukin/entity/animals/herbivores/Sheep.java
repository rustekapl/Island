package ru.javarush.island.khryukin.entity.animals.herbivores;

import ru.javarush.island.khryukin.entity.animals.Animal;
import ru.javarush.island.khryukin.entity.organisms.Limit;
import ru.javarush.island.khryukin.entity.organisms.Organism;
import ru.javarush.island.khryukin.property.Setting;

public class Sheep extends Animal {
    public Sheep(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }

    public static Organism birth() {
        return new Sheep(Setting.SHEEP_NAME, Setting.SHEEP_ICON, Setting.SHEEP_MAX_WEIGHT, new Limit(Setting.SHEEP_MAX_WEIGHT, Setting.SHEEP_MAX_COUNT, Setting.SHEEP_MAX_SPEED, Setting.SHEEP_MAX_FOOD));
    }
}
