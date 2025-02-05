package ru.javarush.island.volokitin.services;

import ru.javarush.island.volokitin.entities.organisms.Organism;
import ru.javarush.island.volokitin.entities.organisms.animals.Animal;
import ru.javarush.island.volokitin.entities.world.Area;

public class Task {
    private final Organism organism;
    private final Area area;

    public Task(Organism organism, Area area) {
        this.organism = organism;
        this.area = area;
    }

    public void perform() {
        if (organism instanceof Animal animal) {
            if (animal.eat(area)) {
                animal.growUp(area);
                animal.multiply(area);
            }
            animal.move(area);
        } else {
            organism.growUp(area);
            organism.multiply(area);
        }
        organism.starve(area);
    }
}
