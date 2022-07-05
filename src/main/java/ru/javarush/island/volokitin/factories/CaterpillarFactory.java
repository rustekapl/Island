package ru.javarush.island.volokitin.factories;

import ru.javarush.island.volokitin.entities.organisms.Organism;
import ru.javarush.island.volokitin.entities.organisms.animals.herbivores.Caterpillar;

public class CaterpillarFactory implements OrganismFactory {
    @Override
    public Organism createOrganism() {
        return new Caterpillar();
    }
}
