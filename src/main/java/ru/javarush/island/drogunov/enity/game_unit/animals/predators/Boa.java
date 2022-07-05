package ru.javarush.island.drogunov.enity.game_unit.animals.predators;

import ru.javarush.island.drogunov.annotations.UnitSetting;
import ru.javarush.island.drogunov.enity.game_unit.Limits;

@UnitSetting(name = "Удав", icon = "\uD83D\uDC0D", weight = 15, maxPopulations = 40, maxSteps = 1, satiety = 3)
public class Boa extends Predator {
    public Boa(String name, String icon, Limits limits) {
        super(name, icon, limits);
    }
}

