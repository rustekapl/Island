package ru.javarush.island.bityutskih.services;

public class ServiceSleep {
    private ServiceSleep() {
    }

    public static void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}