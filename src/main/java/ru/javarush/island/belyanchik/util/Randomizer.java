package ru.javarush.island.belyanchik.util;

import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {
    private Randomizer() {
    }

    public static int get(int from, int to) {
        return ThreadLocalRandom.current().nextInt(from, to);
    }

    public static int get(int max) {
        return ThreadLocalRandom.current().nextInt(0, max);
    }

}
