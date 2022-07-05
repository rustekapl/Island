package ru.javarush.island.bulimov.exception;

public class IslandRunException extends RuntimeException{
    public IslandRunException() {
        super();
    }

    public IslandRunException(String message) {
        super(message);
    }

    public IslandRunException(String message, Throwable cause) {
        super(message, cause);
    }
}
