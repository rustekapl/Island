package ru.javarush.island.stepanov.utils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {

    private RandomGenerator(){
    }

    public static int get(int to){
        return ThreadLocalRandom.current().nextInt(0, to);
    }
    public static int get(int from, int to){
        return ThreadLocalRandom.current().nextInt(from, to);
    }

}
