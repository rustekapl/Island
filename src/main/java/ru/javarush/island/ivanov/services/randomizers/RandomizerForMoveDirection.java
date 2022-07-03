package ru.javarush.island.ivanov.services.randomizers;

import ru.javarush.island.ivanov.services.move_services.Directions;

import java.util.concurrent.ThreadLocalRandom;

public class RandomizerForMoveDirection {

    public static Directions getResult() {
        int maxLength = Directions.values().length;
        int randomValue = ThreadLocalRandom.current().nextInt(0, maxLength);
        return Directions.values()[randomValue];
    }
}
