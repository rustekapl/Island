package ru.javarush.island.drogunov.enity.game_unit.animals.herbivores;

import ru.javarush.island.drogunov.annotations.UnitSetting;
import ru.javarush.island.drogunov.enity.game_unit.Limits;

@UnitSetting(name = "Утка", icon = "\uD83E\uDD86", weight = 1, maxPopulations = 220, maxSteps = 4, satiety = 0.15)
public class Duck extends Herbivores {
    public Duck(String name, String icon, Limits limits) {
        super(name, icon, limits);
    }
}
