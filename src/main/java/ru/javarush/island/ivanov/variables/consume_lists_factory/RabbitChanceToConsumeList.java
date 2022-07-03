package ru.javarush.island.ivanov.variables.consume_lists_factory;

import java.util.HashMap;
import java.util.Map;

public class RabbitChanceToConsumeList extends ChanceToConsumeList {
    private static final Map<String, Integer> chanceToConsume = new HashMap<>();

    static {
        chanceToConsume.put("Bear", 0);
        chanceToConsume.put("Boar", 0);
        chanceToConsume.put("Buffalo", 0);
        chanceToConsume.put("Caterpillar", 0);
        chanceToConsume.put("Deer", 0);
        chanceToConsume.put("Duck", 0);
        chanceToConsume.put("Fox", 0);
        chanceToConsume.put("Goat", 0);
        chanceToConsume.put("Hawk", 0);
        chanceToConsume.put("Herbs", 100);
        chanceToConsume.put("Horse", 0);
        chanceToConsume.put("Rabbit", 0);
        chanceToConsume.put("Rat", 0);
        chanceToConsume.put("Sheep", 0);
        chanceToConsume.put("Snake", 0);
        chanceToConsume.put("Wolf", 0);
    }

    public RabbitChanceToConsumeList() {
    }

    public Map<String, Integer> getListOfPercents() {
        return chanceToConsume;
    }
}
