package ru.javarush.island.khmelov.exception;

@SuppressWarnings("unused")
public class InitGameException extends RuntimeException{
    public InitGameException() {
    }

    public InitGameException(String message) {
        super(message);
    }

    public InitGameException(String message, Throwable cause) {
        super(message, cause);
    }

    public InitGameException(Throwable cause) {
        super(cause);
    }
}
