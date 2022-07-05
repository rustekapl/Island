package ru.javarush.island.vlasov.entity;

import java.util.HashMap;

public class Eagle extends Predator {
    private final HashMap<String, Integer> CHANCE_TO_EAT = new HashMap<>();

    public Eagle() {
        super(6, 20, 3, 1);
        CHANCE_TO_EAT.put(Duck.class.getCanonicalName(), 80);
        CHANCE_TO_EAT.put(Fox.class.getCanonicalName(), 10);
        CHANCE_TO_EAT.put(Mouse.class.getCanonicalName(), 90);
        CHANCE_TO_EAT.put(Rabbit.class.getCanonicalName(), 90);
    }

    public HashMap<String, Integer> getChanceToEat() {
        return CHANCE_TO_EAT;
    }

    public Nature getInstance() {
        return new Eagle();
    }

    @Override
    public String toString() {
        return "Eagle";
    }
}
