package ru.javarush.island.volokitin.factories;

import ru.javarush.island.volokitin.entities.organisms.Organism;
import ru.javarush.island.volokitin.entities.organisms.plants.Plant;

public class PlantFactory implements OrganismFactory {
    @Override
    public Organism createOrganism() {
        return new Plant();
    }
}
