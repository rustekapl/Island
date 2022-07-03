package ru.javarush.island.kossatyy.exception;

@SuppressWarnings("unused")
public class CreatureOperationFail extends RuntimeException {

    //TODO ---  WOW! 2 custom Exception !!! Yes..

    public CreatureOperationFail() {
    }

    public CreatureOperationFail(String message) {
        super(message);
    }

    public CreatureOperationFail(String message, Throwable cause) {
        super(message, cause);
    }

    public CreatureOperationFail(Throwable cause) {
        super(cause);
    }

}
