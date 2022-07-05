package ru.javarush.island.drogunov.enity.game_unit.animals.herbivores;

import ru.javarush.island.drogunov.annotations.UnitSetting;
import ru.javarush.island.drogunov.enity.game_unit.Limits;

@UnitSetting(name = "Овца", icon = "\uD83D\uDC11", weight = 70, maxPopulations = 140, maxSteps = 3, satiety = 15)
public class Sheep extends Herbivores {
    public Sheep(String name, String icon, Limits limits) {
        super(name, icon, limits);
    }
}
