package ru.javarush.island.ryabov.util;

import ru.javarush.island.ryabov.entity.organisms.types.Organism;

import java.util.List;

public interface Factory {
    List<Organism> getAllPrototypes();
}