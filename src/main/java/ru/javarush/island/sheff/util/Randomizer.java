package ru.javarush.island.sheff.util;

import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {

    //TODO ---  I can create instance

    public static int getZeroToBound(int bound) {
        return ThreadLocalRandom.current().nextInt(0, bound);
    }

    public static boolean getChance(int chance) {
        return getZeroToBound(100) < chance;
    }

    public static int getFromArrayInt(int[] range) {
        if (range.length > 0 && range[1] > range[0])
            return ThreadLocalRandom.current().nextInt(range[0], range[1]);
        else
            return 1;
    }
}
