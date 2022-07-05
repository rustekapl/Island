package ru.javarush.island.volokitin.factories;

import ru.javarush.island.volokitin.entities.organisms.Organism;
import ru.javarush.island.volokitin.entities.organisms.animals.carnivores.Eagle;

public class EagleFactory implements OrganismFactory {
    @Override
    public Organism createOrganism() {
        return new Eagle();
    }
}
