package ru.javarush.island.khryukin.entity.animals.herbivores;

import ru.javarush.island.khryukin.entity.animals.Animal;
import ru.javarush.island.khryukin.entity.organisms.Limit;
import ru.javarush.island.khryukin.entity.organisms.Organism;
import ru.javarush.island.khryukin.property.Setting;

public class Goat extends Animal {
    public Goat(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }

    public static Organism birth() {
        return new Goat(Setting.GOAT_NAME, Setting.GOAT_ICON, Setting.GOAT_MAX_WEIGHT, new Limit(Setting.GOAT_MAX_WEIGHT, Setting.GOAT_MAX_COUNT, Setting.GOAT_MAX_SPEED, Setting.GOAT_MAX_FOOD));
    }
}
