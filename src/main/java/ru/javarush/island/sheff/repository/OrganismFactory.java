package ru.javarush.island.sheff.repository;

import ru.javarush.island.sheff.entities.organisms.Limit;
import ru.javarush.island.sheff.entities.organisms.Organism;

import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

public interface OrganismFactory {

    Organism getNewOrganism(OrganismTypes organismType);

    ConcurrentHashMap<String, HashSet<Organism>> getNewOrganismNamesMap();

    Limit getPrototypeOrganismLimit(OrganismTypes organismType);

}
