package ru.javarush.island.drogunov;

import ru.javarush.island.drogunov.game_space.GameSpace;
import ru.javarush.island.drogunov.util.InitializerGame;
import ru.javarush.island.drogunov.util.Injector;

public class Runner {
    public static void main(String[] args) {

        InitializerGame initializerGame = (InitializerGame) Injector.injectDependencies(InitializerGame.class);
        System.out.println(GameSpace.getInstance());

    }


}
