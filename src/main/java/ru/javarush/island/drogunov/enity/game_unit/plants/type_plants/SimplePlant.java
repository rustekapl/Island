package ru.javarush.island.drogunov.enity.game_unit.plants.type_plants;

import ru.javarush.island.drogunov.annotations.UnitSetting;
import ru.javarush.island.drogunov.enity.game_unit.Limits;
import ru.javarush.island.drogunov.enity.game_unit.plants.Plant;

@UnitSetting(name = "Растения", icon = "\uD83C\uDF3F\uD83C\uDF3F", weight = 1, maxPopulations = 200)
public class SimplePlant extends Plant {
    public SimplePlant(String name, String icon, Limits limits) {
        super(name, icon, limits);
    }


}
