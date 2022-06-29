package ru.javarush.ivanov.island.services.randomizers;

import ru.javarush.ivanov.island.entities.Creature;

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
