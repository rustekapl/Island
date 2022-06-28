package ru.javarush.island.ivanov.services.randomizers;

import java.util.concurrent.ThreadLocalRandom;

public class RandomizerForMoveDirection {
    public static int getResult() {
        //TODO Coding. Magic values or methods. Bad reading and understanding
        return ThreadLocalRandom.current().nextInt(1, 5);
    }
}
