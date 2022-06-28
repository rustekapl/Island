package ru.javarush.island.kossatyy.util;

/*----Unused----*/

public class ClassFinder { // TODO почитать тему про ресурсы JAVA?
    //TODO Coding. Hard code. Not flexible  (пришлось это долго искать после смнеы пакета)
    public static final String[] searchPackages = {
            "ru.javarush.island.kossatyy.entity.creatures.fauna.carnivores",
            "ru.javarush.island.kossatyy.entity.creatures.fauna.herbivorous",
            "ru.javarush.island.kossatyy.entity.creatures.flora"};

    public Class<?> findClassByName(String name) {

        String nameCapitalized = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();

        for (String searchPackage : searchPackages) {
            try {
                return Class.forName(searchPackage + "." + nameCapitalized);
            } catch (ClassNotFoundException e) {
                System.err.printf("Класс %s не найден", nameCapitalized);
            }
        }
        return null; // TODO another
    }
}
