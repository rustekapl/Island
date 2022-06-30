package ru.javarush.island.aleev.utils;

import java.util.concurrent.ThreadLocalRandom;


public class Randomizer {

    private Randomizer() {
    }

    public static int get(int from, int to) {

        return ThreadLocalRandom.current().nextInt(from, to);
    }

    public static double get(double from, double to) {

        return ThreadLocalRandom.current().nextDouble(from, to);
    }


    public static boolean get(int probability) {
        return get(0, 100) < probability;

    }
}
