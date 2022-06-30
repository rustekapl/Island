package ru.javarush.island.hozhasaitov.app.entity.map;

import java.util.Arrays;
import java.util.List;

public enum Relief {
    MOUNTAINS(" |Г| "),
    MEADOW(" |Х| "),
    PLAIN(" |Р| ");

    private final String image;

    Relief(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public static List<Relief> getListRelief() {
        return Arrays.asList(Relief.values());
    }


}

