package ru.javarush.island.khryukin.entity.animals.predators;

import ru.javarush.island.khryukin.entity.animals.Animal;
import ru.javarush.island.khryukin.entity.organisms.Limit;
import ru.javarush.island.khryukin.entity.organisms.Organism;
import ru.javarush.island.khryukin.property.Setting;

public class Eagle extends Animal {
    public Eagle(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }

    public static Organism birth() {
        return new Eagle(Setting.EAGLE_NAME, Setting.EAGLE_ICON, Setting.EAGLE_MAX_WEIGHT, new Limit(Setting.EAGLE_MAX_WEIGHT, Setting.EAGLE_MAX_COUNT, Setting.EAGLE_MAX_SPEED, Setting.EAGLE_MAX_FOOD));
    }
}
