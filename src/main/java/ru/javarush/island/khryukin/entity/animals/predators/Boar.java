package ru.javarush.island.khryukin.entity.animals.predators;

import ru.javarush.island.khryukin.entity.animals.Animal;
import ru.javarush.island.khryukin.entity.organisms.Limit;
import ru.javarush.island.khryukin.entity.organisms.Organism;
import ru.javarush.island.khryukin.property.Setting;

public class Boar extends Animal {
    public Boar(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }

    public static Organism birth() {
        return new Boar(Setting.BOAR_NAME, Setting.BOAR_ICON, Setting.BOAR_MAX_WEIGHT, new Limit(Setting.BOAR_MAX_WEIGHT, Setting.BOAR_MAX_COUNT, Setting.BOAR_MAX_SPEED, Setting.BOAR_MAX_FOOD));
    }
}
