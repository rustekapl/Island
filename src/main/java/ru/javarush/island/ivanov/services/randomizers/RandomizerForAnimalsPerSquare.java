package ru.javarush.island.ivanov.services.randomizers;

import ru.javarush.island.ivanov.entities.Creature;

import java.util.concurrent.ThreadLocalRandom;

public class RandomizerForAnimalsPerSquare {

    public static int getResult(Creature squareWildLife) {
        //TODO Code style. Need reformat or extraction to methods | variables | constants
        return ThreadLocalRandom.current().nextInt(1, squareWildLife.getParams().getMaxNumberPerSquare() + 1);
    }

    private RandomizerForAnimalsPerSquare() {
    }
}
