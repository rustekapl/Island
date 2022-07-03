package ru.javarush.island.khryukin.entity.animals.predators;

import ru.javarush.island.khryukin.entity.animals.Animal;
import ru.javarush.island.khryukin.entity.organisms.Limit;
import ru.javarush.island.khryukin.entity.organisms.Organism;
import ru.javarush.island.khryukin.property.Setting;

public class Fox extends Animal {
    public Fox(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }

    public static Organism birth() {
        return new Fox(Setting.FOX_NAME, Setting.FOX_ICON, Setting.FOX_MAX_WEIGHT, new Limit(Setting.FOX_MAX_WEIGHT, Setting.FOX_MAX_COUNT, Setting.FOX_MAX_SPEED, Setting.FOX_MAX_FOOD));
    }
}
