package ru.javarush.island.synckevich.game;

import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {
    private Randomizer() {
    }

    public static int get(int bound) {
        return ThreadLocalRandom.current().nextInt(bound);
    }
}
