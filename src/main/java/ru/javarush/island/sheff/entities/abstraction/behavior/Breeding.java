package ru.javarush.island.sheff.entities.abstraction.behavior;

import ru.javarush.island.sheff.entities.organisms.Organism;

import java.util.Set;

public interface Breeding {

    Set<Organism> spawn();
}
