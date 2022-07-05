package ru.javarush.island.drogunov.enity.game_unit.animals.herbivores;

import ru.javarush.island.drogunov.annotations.UnitSetting;
import ru.javarush.island.drogunov.enity.game_unit.Limits;

@UnitSetting(name = "Гусеница", icon = " \uD83D\uDC1B", maxPopulations = 1000, satiety = 100, weight = 0.01)
public class Caterpillar extends Herbivores {
    public Caterpillar(String name, String icon, Limits limits) {
        super(name, icon, limits);
    }
}
