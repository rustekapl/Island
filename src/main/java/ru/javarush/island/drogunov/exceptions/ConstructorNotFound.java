package ru.javarush.island.drogunov.exceptions;

public class ConstructorNotFound extends RuntimeException {
    public ConstructorNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
