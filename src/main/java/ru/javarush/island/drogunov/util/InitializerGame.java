package ru.javarush.island.drogunov.util;

import ru.javarush.island.drogunov.enity.annotations.Initialize;
import ru.javarush.island.drogunov.game_space.GameSettings;
import ru.javarush.island.drogunov.game_space.GameSpace;

public class InitializerGame {
    @Initialize
    GameSettings gameSettings;
    @Initialize
    GameSpace gameSpace;
    @Initialize
    StartPopulation startPopulation;


}
