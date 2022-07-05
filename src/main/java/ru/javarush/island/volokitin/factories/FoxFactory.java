package ru.javarush.island.volokitin.factories;

import ru.javarush.island.volokitin.entities.organisms.Organism;
import ru.javarush.island.volokitin.entities.organisms.animals.carnivores.Fox;

public class FoxFactory implements OrganismFactory {
    @Override
    public Organism createOrganism() {
        return new Fox();
    }
}
