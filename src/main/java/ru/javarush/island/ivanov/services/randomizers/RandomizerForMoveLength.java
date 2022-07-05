package ru.javarush.island.ivanov.services.randomizers;

import java.util.concurrent.ThreadLocalRandom;

public class RandomizerForMoveLength {
    public static int getResult(int maxMoveLength) {
        if (maxMoveLength != 0) {
            return ThreadLocalRandom.current().nextInt(1, maxMoveLength + 1);
        }
        return 0;
    }

    private RandomizerForMoveLength() {
    }
}
