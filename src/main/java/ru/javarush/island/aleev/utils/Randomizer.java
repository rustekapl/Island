package ru.javarush.island.aleev.utils;

import java.util.concurrent.ThreadLocalRandom;


public class Randomizer {

    private Randomizer() {
    }

    public static int get(int from, int to){

        return ThreadLocalRandom.current().nextInt(from, to);
    }


}
