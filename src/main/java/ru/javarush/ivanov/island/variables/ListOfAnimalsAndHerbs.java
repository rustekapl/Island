package ru.javarush.ivanov.island.variables;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public enum ListOfAnimalsAndHerbs {
    BEAR("Bear"),
    BOAR("Boar"),
    BUFFALO("Buffalo"),
    CATERPILLAR("Caterpillar"),
    DEER("Deer"),
    DUCK("Duck"),
    FOX("Fox"),
    GOAT("Goat"),
    HAWK("Hawk"),
    HERBS("Herbs"),
    HORSE("Horse"),
    RABBIT("Rabbit"),
    RAT("Rat"),
    SHEEP("Sheep"),
    SNAKE("Snake"),
    WOLF("Wolf");

    final String currency;

    public String getCurrency() {
        return currency;
    }

    ListOfAnimalsAndHerbs(String currency) {
        this.currency = currency;
    }

    public static Set<String> getCurrencies() {
        Set<String> result = new HashSet<>();
        List.of(ListOfAnimalsAndHerbs.values()).forEach(o -> result.add(o.currency));
        return result;
    }
}
