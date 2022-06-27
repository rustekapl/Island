package ru.javarush.island.drogunov.exceptions;

public class ClassForDependenceNotFound extends RuntimeException {
    public ClassForDependenceNotFound(String message) {
        super(message);
    }

    public ClassForDependenceNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
