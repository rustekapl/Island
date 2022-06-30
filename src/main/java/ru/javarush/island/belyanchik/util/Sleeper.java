package ru.javarush.island.belyanchik.util;

public class Sleeper {

    //TODO ---  default constructor. In Util classes it is usually with private modifier
    public Sleeper() {
    }

    public static void sleep(int timeout) {
        try {
            Thread.sleep(timeout / 100);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }
}
