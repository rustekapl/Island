package ru.javarush.island.bulimov.util;

import java.util.concurrent.ThreadLocalRandom;

public class Random {

    private Random() {
    }

    public static int random(int maxValue) {
        return ThreadLocalRandom.current().nextInt(maxValue);
    }

    public static int random(int minValue, int maxValue) {
        return ThreadLocalRandom.current().nextInt(minValue, maxValue);
    }

    public static double random(double minValue, double maxValue) {
        return ThreadLocalRandom.current().nextDouble(minValue, maxValue);
    }
}
