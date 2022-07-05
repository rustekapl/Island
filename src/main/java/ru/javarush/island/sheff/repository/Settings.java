package ru.javarush.island.sheff.repository;

import ru.javarush.island.sheff.exception.InitGameException;

import java.util.Properties;
import java.util.stream.Stream;

public enum Settings {
    ROWS,
    COLS,
    DEFAULT,
    DURATION,
    START,
    COUNT_OF_BEAR,
    COUNT_OF_BOA,
    COUNT_OF_BOAR,
    COUNT_OF_BUFFALO,
    COUNT_OF_CATERPILLAR,
    COUNT_OF_DEER,
    COUNT_OF_DUCK,
    COUNT_OF_EAGLE,
    COUNT_OF_FOX,
    COUNT_OF_GOAT,
    COUNT_OF_HORSE,
    COUNT_OF_MOUSE,
    COUNT_OF_PLANT,
    COUNT_OF_RABBIT,
    COUNT_OF_SHEEP,
    COUNT_OF_WOLF;

    private static final String PATH = "/sheff/config.properties";

    private static Properties properties;

    private Integer value;

    private void init() {
        if (properties == null) {
            properties = new Properties();
            try {
                properties.load(Settings.class.getResourceAsStream(PATH));

            } catch (Exception e) {
                throw new InitGameException("Unable to load " + PATH + " file from classpath.", e);
            }
        }

        value = Integer.parseInt((String) properties
                .get(Stream.of(this.toString().split("_"))
                        .reduce((first, last) -> last)
                        .orElse(DEFAULT.toString())
                        .toLowerCase()));
    }

    public Integer getValue() {
        if (value == null) {
            init();
        }
        return value;
    }
}
