package ru.javarush.island.sheff.entities.organisms.animals;

import ru.javarush.island.sheff.entities.abstraction.behavior.Eating;
import ru.javarush.island.sheff.entities.abstraction.behavior.Moving;
import ru.javarush.island.sheff.entities.map.Cell;
import ru.javarush.island.sheff.entities.organisms.Organism;
import ru.javarush.island.sheff.util.Randomizer;
import lombok.Getter;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
public abstract class Animal extends Organism implements Eating, Moving {

    public Animal(Animal other) {
        super(other);
    }

    @Override
    public void eat(ConcurrentHashMap<String, HashSet<Organism>> map) {
        Set<Organism> organisms;
        organisms = filterByRation(map)
                .values()
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
        for (Organism organism : organisms) {
            if (getNeedFood() > 0) {
                if (organism.isKilled(Randomizer.getChance(limit.getRation().get(organism.getName())))) {
                    if (getNeedFood() <= organism.getWeight()) {
                        weight += organism.wasEatenBy(getNeedFood());
                    } else {
                        weight += organism.wasEatenBy(organism.getWeight());
                    }
                }
            } else break;
        }
    }

    @Override
    public Set<Organism> spawn() {
        canBreed = false;
        int random = Randomizer.getFromArrayInt(getLimit().getOffspring());
        this.weight = weight / (random + 1);
        return Stream.generate(this::copy)
                .limit(random)
                .collect(Collectors.toSet());
    }

    @Override
    public void selectOfDirection(List<Cell> cells) {
        if (steps > 0) {
            cells.stream()
                    .map(Cell::getResidents)
                    .map(this::filterByRation)
                    .max(this::compareWeight)
                    .map(Map::values)
                    .stream()
                    .flatMap(Collection::stream)
                    .flatMap(HashSet::stream)
                    .findFirst().ifPresent(organism -> location.setLocation(organism.getLocation()));
            steps--;
        }
    }

    private int compareWeight(Map<String, HashSet<Organism>> map1, Map<String, HashSet<Organism>> map2) {
        Double map1Weight = map1.values().stream()
                .flatMap(Set::stream)
                .map(Organism::getWeight)
                .reduce(Double::sum)
                .orElse(0d);

        Double map2Weight = map2.values().stream()
                .flatMap(Set::stream)
                .map(Organism::getWeight)
                .reduce(Double::sum)
                .orElse(0d);
        return map1Weight.compareTo(map2Weight);
    }

    private Map<String, HashSet<Organism>> filterByRation(Map<String, HashSet<Organism>> map) {
        return map.entrySet()
                .stream()
                .filter(entry -> limit.getRation().containsKey(entry.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    }

    private double getNeedFood() {
        return Math.min(
                limit.getMaxFood(),
                limit.getMaxWeight() - getWeight());
    }

    @Override
    public void endTurn() {
        steps = limit.getMaxSpeed();
        canBreed = isFemaleGender();
        weight = weight - limit.getMaxFood() / 1.5 - 0.001;
        dead = weight <= 0;
    }
}