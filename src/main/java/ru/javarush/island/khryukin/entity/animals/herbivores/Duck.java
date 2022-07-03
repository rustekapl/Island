package ru.javarush.island.khryukin.entity.animals.herbivores;

import ru.javarush.island.khryukin.entity.animals.Animal;
import ru.javarush.island.khryukin.entity.organisms.Limit;
import ru.javarush.island.khryukin.entity.organisms.Organism;
import ru.javarush.island.khryukin.property.Setting;

public class Duck extends Animal {
    public Duck(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }

    public static Organism birth() {
        return new Duck(Setting.DUCK_NAME, Setting.DUCK_ICON, Setting.DUCK_MAX_WEIGHT, new Limit(Setting.DUCK_MAX_WEIGHT, Setting.DUCK_MAX_COUNT, Setting.DUCK_MAX_SPEED, Setting.DUCK_MAX_FOOD));
    }
}
