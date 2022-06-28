package ru.javarush.island.smulko.entity.preferences;

import ru.javarush.island.smulko.entity.organizms.animals.herbivores.Deer;
import ru.javarush.island.smulko.entity.organizms.animals.herbivores.Horse;

import java.util.HashMap;
import java.util.Map;

public class Preferences {

    private final Map<Class<?>, Fields> preferences = new HashMap<>();

    private static final Preferences instance = new Preferences();

    private Preferences() {
        initialize();
    }

    private void initialize() {
        preferences.put(Horse.class, new Fields("Лошадь", "\uD83D\uDC0E", 400, 4, 20));
        preferences.put(Deer.class, new Fields("Олень", " \uD83E\uDD8C", 50, 3, 20));
    }


    public static Map<Class<?>, Fields> getPreferencesMap() {
        return instance.preferences;
    }

}
