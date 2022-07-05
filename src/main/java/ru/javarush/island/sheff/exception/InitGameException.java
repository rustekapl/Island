package ru.javarush.island.sheff.exception;

public class InitGameException extends RuntimeException{

    public InitGameException(String message) {
        super(message);
    }

    public InitGameException(String message, Throwable cause) {
        super(message, cause);
    }
}
