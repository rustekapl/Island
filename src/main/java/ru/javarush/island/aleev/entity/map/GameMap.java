package ru.javarush.island.aleev.entity.map;


import ru.javarush.island.aleev.cotstants.Constants;
import ru.javarush.island.aleev.cotstants.OrganismType;
import ru.javarush.island.aleev.entity.organism.Organism;
import ru.javarush.island.aleev.factories.OrganismFactory;
import ru.javarush.island.aleev.parameters.GameParameters;
import ru.javarush.island.aleev.utils.Randomizer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class GameMap {


    public static final int rows = Constants.WIDTH_ISLAND;
    public static final int colls = Constants.LENGTH_ISLAND;

    public static Cell[][] cells = new Cell[rows][colls];


    //make game field
    public void init() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }
    }

    //fill cell by organismes

    public void fill() {
        for (Cell[] cell : cells) {
            for (Cell value : cell) {
                OrganismType[] setOfOrganisms = OrganismType.values();
                for (OrganismType organismType :
                        setOfOrganisms) {
                    int count = Randomizer.get(2, GameParameters.getInstance().getParameters().get(organismType).getMaxCount());
                    Set<Organism> organismSet = new HashSet<>();
                    for (int k = 0; k < count; k++) {
                        Organism organism = OrganismFactory.getInstance().getPrototype(organismType);
                        organismSet.add(organism);
                    }
                    value.resident.put(organismType, organismSet);
                }
            }
        }
    }

    public void printInfo() {
        Map<String, Integer> map = new HashMap<>();
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                System.out.print("|\t");
                Map<OrganismType, Set<Organism>> residentes = cell.getOrganisms();
                residentes.values()
                        .stream()
                        .filter(s -> s.size() > 0)
                        .forEach(s -> map.put(s.stream().findFirst().get().toString(), s.size()));
                System.out.println("\t|" + cell.getRow() + "/" + cell.getCol() + "|\t" + map);

            }
            System.out.println();
        }
        int totalCount = 0;

        for (Cell[] cell : cells) {
            for (Cell item : cell) {
                Map<OrganismType, Set<Organism>> map1 = item.resident;
                for (Set<Organism> value : map1.values()) {
                    for (Organism ignored : value) {
                        totalCount++;
                    }
                }
            }
        }
        System.out.println("============================================================================================================================");
        System.out.println("Total value of Organisms are  " + totalCount);
        System.out.println("============================================================================================================================");
    }

    //Make a tact
    public void life() {
        for (Cell[] cell : cells) {
            for (Cell value : cell) {
                value.life();
            }
        }
    }


}



