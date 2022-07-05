package ru.javarush.island.volokitin.factories;

import ru.javarush.island.volokitin.entities.organisms.Organism;
import ru.javarush.island.volokitin.entities.organisms.animals.carnivores.Wolf;

public class WolfFactory implements OrganismFactory {
    @Override
    public Organism createOrganism() {
        return new Wolf();
    }
}
