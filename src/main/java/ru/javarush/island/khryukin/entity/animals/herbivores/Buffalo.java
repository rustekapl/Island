package ru.javarush.island.khryukin.entity.animals.herbivores;

import ru.javarush.island.khryukin.entity.animals.Animal;
import ru.javarush.island.khryukin.entity.organisms.Limit;
import ru.javarush.island.khryukin.entity.organisms.Organism;
import ru.javarush.island.khryukin.property.Setting;

public class Buffalo extends Animal {
    public Buffalo(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }

    public static Organism birth() {
        return new Buffalo(Setting.BUFFALO_NAME, Setting.BUFFALO_ICON, Setting.BUFFALO_MAX_WEIGHT, new Limit(Setting.BUFFALO_MAX_WEIGHT, Setting.BUFFALO_MAX_COUNT, Setting.BUFFALO_MAX_SPEED, Setting.BUFFALO_MAX_FOOD));
    }
}
