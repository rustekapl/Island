package ru.javarush.island.ivanov.variables.consume_lists_factory;

import java.util.HashMap;
import java.util.Map;

public class HawkChanceToConsumeList extends ChanceToConsumeList {
    private static Map<String, Integer> chanceToConsume = new HashMap<>();

    static {
        chanceToConsume.put("Bear", 0);
        chanceToConsume.put("Boar", 0);
        chanceToConsume.put("Buffalo", 0);
        chanceToConsume.put("Caterpillar", 0);
        chanceToConsume.put("Deer", 0);
        chanceToConsume.put("Duck", 80);
        chanceToConsume.put("Fox", 10);
        chanceToConsume.put("Goat", 0);
        chanceToConsume.put("Hawk", 0);
        chanceToConsume.put("Herbs", 0);
        chanceToConsume.put("Horse", 0);
        chanceToConsume.put("Rabbit", 90);
        chanceToConsume.put("Rat", 90);
        chanceToConsume.put("Sheep", 0);
        chanceToConsume.put("Snake", 0);
        chanceToConsume.put("Wolf", 0);
    }

    public HawkChanceToConsumeList() {
    }

    public Map<String, Integer> getListOfPercents() {
        return chanceToConsume;
    }

}
