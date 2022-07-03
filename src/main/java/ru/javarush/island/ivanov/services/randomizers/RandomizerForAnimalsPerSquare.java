package ru.javarush.island.ivanov.services.randomizers;

import ru.javarush.island.ivanov.entities.Creature;

import java.util.concurrent.ThreadLocalRandom;

public class RandomizerForAnimalsPerSquare {

    public static int getResult(Creature squareWildLife) {
        int maxBound = squareWildLife
                .getParams()
                .getMaxNumberPerSquare() + 1;
        return ThreadLocalRandom.current().nextInt(1, maxBound);
    }

    private RandomizerForAnimalsPerSquare() {
    }
}
