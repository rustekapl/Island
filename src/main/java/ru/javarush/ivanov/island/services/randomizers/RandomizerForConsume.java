package ru.javarush.ivanov.island.services.randomizers;

import java.util.concurrent.ThreadLocalRandom;

public class RandomizerForConsume {
    public static boolean getResult(int maxValue) {
        if (maxValue==100){
            return true;
        }
        if (maxValue > 0) {
            int rnd = ThreadLocalRandom.current().nextInt(0, 100);
            return rnd >= maxValue;
        }
        return false;
    }

    private RandomizerForConsume() {
    }
}
