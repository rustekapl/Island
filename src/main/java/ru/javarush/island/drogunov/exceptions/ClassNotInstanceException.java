package ru.javarush.island.drogunov.exceptions;

public class ClassNotInstanceException extends RuntimeException {
    public ClassNotInstanceException(String message, Throwable cause) {
        super(message, cause);
    }
}
