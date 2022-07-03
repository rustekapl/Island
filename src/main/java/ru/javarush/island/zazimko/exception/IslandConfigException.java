package ru.javarush.island.zazimko.exception;

@SuppressWarnings("unused")
public class IslandConfigException extends RuntimeException {
    public IslandConfigException() {
    }

    public IslandConfigException(String message) {
        super(message);
    }

    public IslandConfigException(String message, Throwable cause) {
        super(message, cause);
    }

    public IslandConfigException(Throwable cause) {
        super(cause);
    }
}
