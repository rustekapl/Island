package ru.javarush.island.drogunov.game_space;

import lombok.Getter;
import ru.javarush.island.drogunov.enity.annotations.Settings;

public class GameSettings {

    //TODO Code style. Many warnings. Skip or fix it.

    private static GameSettings gameSettings;

    public GameSettings() {
        getInstance();
    }

    private GameSettings(int a) {

    }

    public static GameSettings getInstance() {
        if (gameSettings == null) {
            return new GameSettings(1);
        }
        return gameSettings;
    }


    @Getter
    @Settings(code = 1, name = "Ширина игрового поля")
    private int width = 100;

    @Getter
    @Settings(code = 2, name = "Длина игрового поля")
    private int length = 20;

    @Settings(code = 3, name = "Максимальное время игры")
    private int gameTime = 0;
}


