package ru.javarush.island.khryukin.utils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomValue {
    //TODO ---  I can create new RandomValue()
    public static int random(int a, int b){
        return ThreadLocalRandom.current().nextInt(a, b);
    }

    public static double random(double a, double b){
        return ThreadLocalRandom.current().nextDouble(a, b);
    }

    public static boolean get(int a){
        return random(0, 100) < a;
    }
}
