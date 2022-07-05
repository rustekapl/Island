package ru.javarush.island.drogunov.enity.game_unit.animals.herbivores;

import ru.javarush.island.drogunov.annotations.UnitSetting;
import ru.javarush.island.drogunov.enity.game_unit.Limits;

@UnitSetting(name = "Кабан", icon = "\uD83D\uDC03", weight = 400, maxPopulations = 50, maxSteps = 2, satiety = 50)
public class Boar extends Herbivores {
    public Boar(String name, String icon, Limits limits) {
        super(name, icon, limits);
    }
}
