package ru.javarush.island.drogunov.enity.game_unit.animals.predators;

import ru.javarush.island.drogunov.annotations.UnitSetting;
import ru.javarush.island.drogunov.enity.game_unit.Limits;

@UnitSetting(name = "Медведь", icon = "\uD83D\uDC3B", weight = 500, maxPopulations = 5, maxSteps = 2, satiety = 80)
public class Bear extends Predator {
    public Bear(String name, String icon, Limits limits) {
        super(name, icon, limits);
    }
}
