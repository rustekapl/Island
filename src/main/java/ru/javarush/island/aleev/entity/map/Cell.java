package ru.javarush.island.aleev.entity.map;


import ru.javarush.island.aleev.cotstants.Constants;
import ru.javarush.island.aleev.cotstants.OrganismType;
import ru.javarush.island.aleev.entity.organism.Organism;
import ru.javarush.island.aleev.entity.organism.animals.carnivores.Carnivore;
import ru.javarush.island.aleev.entity.organism.animals.herbivores.Herbivore;
import ru.javarush.island.aleev.factories.OrganismFactory;
import ru.javarush.island.aleev.parameters.GameParameters;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Cell {


    private final int row;
    private final int col;


    public Map<OrganismType, Set<Organism>> resident = new HashMap<>();


    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void life() {
        reproduct();
        eat();
        move();

    }


    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }


    private void reproduct() {
        for (Map.Entry<OrganismType, Set<Organism>> pair : resident.entrySet()) {
            OrganismType organismType = pair.getKey();
            Set<Organism> organismSet = pair.getValue();


            int newborns = organismSet.size() / 2;
            if (organismSet.size() < GameParameters.getInstance().getParameters().get(organismType).getMaxCount() - newborns) {
                for (int i = 0; i < newborns; i++) {
                    Organism organism = OrganismFactory.getInstance().getPrototype(organismType);
                    organismSet.add(organism);
                }
            } else {
                newborns = GameParameters.getInstance().getParameters().get(organismType).getMaxCount() - organismSet.size();
                for (int i = 0; i < newborns; i++) {
                    Organism organism = OrganismFactory.getInstance().getPrototype(organismType);
                    organismSet.add(organism);
                }
            }
        }
    }

    private void move() {
        for (Map.Entry<OrganismType, Set<Organism>> resident :
                resident.entrySet()) {
            Set<Organism> organismSet = resident.getValue();
            Iterator<Organism> iterator = organismSet.iterator();
            while (iterator.hasNext()) {
                Organism organism = iterator.next();
                boolean isMove = organism.move(this);
                if (isMove) iterator.remove();
            }
        }
    }

    private void eat() {
        for (Map.Entry<OrganismType, Set<Organism>> pair :
                resident.entrySet()) {
            Set<Organism> organisms = pair.getValue();
            for (Organism organism :
                    organisms) {
                if (organism instanceof Carnivore) {
                    OrganismType[] herbivores = Constants.getHerbivores();
                    for (OrganismType herbivore : herbivores) {
                        ((Carnivore) organism).eat(resident.get(herbivore));
                    }
                } else if (organism instanceof Herbivore) {
                    Set<Organism> plants = resident.get(OrganismType.PLANT);
                    if (plants != null) {
                        ((Herbivore) organism).eat(plants);
                    }
                }
            }
        }
    }


    public Map<OrganismType, Set<Organism>> getOrganisms() {
        return resident;
    }


}

