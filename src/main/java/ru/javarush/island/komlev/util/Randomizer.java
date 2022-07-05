package ru.javarush.island.komlev.util;

import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {
    public Randomizer() {
    }

    public static int random(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    public static double random(double min, double max) {
        return ThreadLocalRandom.current().nextDouble(min, max);
    }

    public static boolean get(int percentRandomizer) {
        return random(0, 100) < percentRandomizer;
    }
}
