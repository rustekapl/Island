package ru.javarush.island.khryukin.entity.animals.predators;

import ru.javarush.island.khryukin.entity.animals.Animal;
import ru.javarush.island.khryukin.entity.organisms.Limit;
import ru.javarush.island.khryukin.entity.organisms.Organism;
import ru.javarush.island.khryukin.property.Setting;

public class Bear extends Animal {
    public Bear(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }

    public static Organism birth() {
        return new Bear(Setting.BEAR_NAME, Setting.BEAR_ICON, Setting.BEAR_MAX_WEIGHT, new Limit(Setting.BEAR_MAX_WEIGHT, Setting.BEAR_MAX_COUNT, Setting.BEAR_MAX_SPEED, Setting.BEAR_MAX_FOOD));
    }
}
