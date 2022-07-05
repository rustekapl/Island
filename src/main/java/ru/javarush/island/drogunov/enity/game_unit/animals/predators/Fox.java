package ru.javarush.island.drogunov.enity.game_unit.animals.predators;

import ru.javarush.island.drogunov.annotations.UnitSetting;
import ru.javarush.island.drogunov.enity.game_unit.Limits;

@UnitSetting(name = "Лиса", icon = "\uD83E\uDD8A", weight = 8, maxPopulations = 30, maxSteps = 2, satiety = 2)
public class Fox extends Predator {
    public Fox(String name, String icon, Limits limits) {
        super(name, icon, limits);
    }
}

