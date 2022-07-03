package ru.javarush.island.khryukin.entity.animals.predators;

import ru.javarush.island.khryukin.entity.organisms.Limit;
import ru.javarush.island.khryukin.entity.organisms.Organism;
import ru.javarush.island.khryukin.entity.animals.Animal;
import ru.javarush.island.khryukin.property.Setting;

public class Wolf extends Animal {

    public Wolf(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }

    //@Override
    public static Organism birth() {
        return new Wolf(Setting.WOLF_NAME, Setting.WOLF_ICON, Setting.WOLF_MAX_WEIGHT, new Limit(Setting.WOLF_MAX_WEIGHT, Setting.WOLF_MAX_COUNT, Setting.WOLF_MAX_SPEED, Setting.WOLF_MAX_FOOD));
    }
}
