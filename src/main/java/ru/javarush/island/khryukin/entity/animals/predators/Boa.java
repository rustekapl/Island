package ru.javarush.island.khryukin.entity.animals.predators;

import ru.javarush.island.khryukin.entity.animals.Animal;
import ru.javarush.island.khryukin.entity.organisms.Limit;
import ru.javarush.island.khryukin.entity.organisms.Organism;
import ru.javarush.island.khryukin.property.Setting;

public class Boa extends Animal {

    public Boa(String name, String icon, double weight, Limit limit) {
        super(name, icon, weight, limit);
    }

    public static Organism birth() {
        return new Boa(Setting.BOA_NAME, Setting.BOA_ICON, Setting.BOA_MAX_WEIGHT, new Limit(Setting.BOA_MAX_WEIGHT, Setting.BOA_MAX_COUNT, Setting.BOA_MAX_SPEED, Setting.BOA_MAX_FOOD));
    }
}
