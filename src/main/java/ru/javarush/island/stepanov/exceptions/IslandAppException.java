package ru.javarush.island.stepanov.exceptions;

public class IslandAppException extends RuntimeException{
    public IslandAppException() {
    }

    public IslandAppException(String message) {
        super(message);
    }

    public IslandAppException(String message, Throwable cause) {
        super(message, cause);
    }

    public IslandAppException(Throwable cause) {
        super(cause);
    }
}
