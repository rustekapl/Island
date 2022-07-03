package ru.javarush.island.bityutskih.services;


import java.util.concurrent.ThreadLocalRandom;

public class ServiceRandoms {
    private ServiceRandoms() {
    }

    public static int getRandomsNum(int num) {
        return ThreadLocalRandom.current().nextInt(num);
    }

    public static int getRandomNum(int from, int num) {

        return ThreadLocalRandom.current().nextInt(from, num);
    }
}


