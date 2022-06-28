package ru.javarush.island.drogunov.util;

import lombok.SneakyThrows;
import ru.javarush.island.drogunov.Constants;
import ru.javarush.island.drogunov.enity.annotations.Populations;
import ru.javarush.island.drogunov.game_space.Cell;
import ru.javarush.island.drogunov.game_space.GameSpace;

public class StartPopulation {
    GameSpace gameSpace = GameSpace.getInstance();


    //TODO закончил тут не работает инициализация мира
    @SneakyThrows
    public StartPopulation() {
        Cell[][] space = gameSpace.getSpace();
        for (Object object : Constants.OBJECTS) {
            Class<?> aClass = object.getClass();
            Populations declaredAnnotation = aClass.getDeclaredAnnotation(Populations.class);
            if (declaredAnnotation != null) {
                for (int i = 0; i < space.length; i++) {
                    for (int t = 0; t < space[i].length; t++) {
                        for (int j = 0; j < Randomizer.getRandomInteger(declaredAnnotation.max()); j++) {
                            aClass.getConstructor().newInstance(i, t);
                        }
                    }
                }
            }
        }


    }

}
