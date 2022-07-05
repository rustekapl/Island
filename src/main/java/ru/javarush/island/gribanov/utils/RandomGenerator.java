package ru.javarush.island.gribanov.utils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {
    private RandomGenerator() {
    }
    public static int random(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    public static double random(double min, double max) {
        return ThreadLocalRandom.current().nextDouble(min, max);
    }

    public static boolean get(int probably) {
        return random(0, 100) < probably;
    }
}
