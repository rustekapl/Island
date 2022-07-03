package ru.javarush.island.zazimko.classes.util;

import java.util.concurrent.ThreadLocalRandom;

public class Randoms {
    private Randoms() {
    }

    public static int getRnd(int from, int to) {
        return ThreadLocalRandom.current().nextInt(from, to + 1);
    }

    public static double getRnd(double from, double to) {
        return ThreadLocalRandom.current().nextDouble(from, to + 1);
    }

    public static boolean get(int percentProbably) {
        return getRnd(0, 100) < percentProbably;
    }
}
