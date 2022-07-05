package ru.javarush.island.drogunov.enity.game_unit.animals.predators;

import ru.javarush.island.drogunov.annotations.UnitSetting;
import ru.javarush.island.drogunov.enity.game_unit.Limits;

@UnitSetting(name = "Волк", icon = "\uD83D\uDC3A", weight = 50, maxPopulations = 30, maxSteps = 3, satiety = 8)
public class Wolf extends Predator {
    public Wolf(String name, String icon, Limits limits) {
        super(name, icon, limits);
    }
}
