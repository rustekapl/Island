package ru.javarush.island.drogunov.enity.game_unit.plants;

import ru.javarush.island.drogunov.enity.game_unit.GameUnit;
import ru.javarush.island.drogunov.enity.game_unit.Limits;
import ru.javarush.island.drogunov.interfaces.Multiple;

public abstract class Plant extends GameUnit implements Multiple {

    public Plant(String name, String icon, Limits limits) {
        super(name, icon, limits);
        super.satiety = 0;
    }

}
