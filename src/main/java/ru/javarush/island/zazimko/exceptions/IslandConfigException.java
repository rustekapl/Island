package ru.javarush.island.zazimko.exceptions;

public class IslandConfigException extends RuntimeException {
    //Будет выбрасываться если при запуске приложения
    // на найден конфигурационный файл в ресурсах
    public IslandConfigException(String message) {
        super(message);
    }
}
