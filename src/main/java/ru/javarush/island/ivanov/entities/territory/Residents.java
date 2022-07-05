package ru.javarush.island.ivanov.entities.territory;

import ru.javarush.island.ivanov.entities.Creature;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Residents extends LinkedHashMap<String, Set<Creature>> {

    @Override
    public Set<Creature> get(Object key) {
        return super.get(key);
    }

    @Override
    public Set<Creature> put(String key, Set<Creature> value) {
        return super.put(key, value);
    }

    @Override
    public void putAll(Map<? extends String, ? extends Set<Creature>> m) {
        super.putAll(m);
    }

}
