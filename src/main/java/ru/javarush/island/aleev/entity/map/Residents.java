package ru.javarush.island.aleev.entity.map;

import ru.javarush.island.aleev.entity.organism.Organismes;

import java.util.LinkedHashMap;

public class Residents extends LinkedHashMap<String, Organismes> {

    private final Cell cell;


    public Residents(Cell cell) {
        this.cell = cell;
    }

    private void checkNull(Object key) {
        this.putIfAbsent(key.toString(), new Organismes());
    }

    @Override
    public Organismes get(Object key) {
        checkNull(key);
        return super.get(key);
    }

    @Override
    public Organismes put(String key, Organismes value) {
        checkNull(key);
        return super.put(key, value);
    }
}
