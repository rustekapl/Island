package ru.javarush.island.bulimov.islandMap;

import ru.javarush.island.bulimov.entity.Organism;
import ru.javarush.island.bulimov.entity.repository.AnimalsFactory;
import ru.javarush.island.bulimov.util.Random;

import java.util.HashSet;
import java.util.Map;


public class Island {
    public int column;
    public int line;
    private static Cell[][] animalMap = new Cell[][]{};

    public Island(int column, int line) {
        this.column = column;
        this.line = line;
        animalMap = new Cell[column][line];
    }

    public void createMap(){
        for (int i = 0; i < animalMap.length; i++) {
            for (int j = 0; j < animalMap[i].length; j++) {
                animalMap[i][j] = new Cell(i,j);

                for(Map.Entry<Integer,Organism> pair : AnimalsFactory.getAnimals().entrySet()){
                    HashSet<Organism> organisms = new HashSet<>();
                    int maxAnimalCell = Random.random(pair.getValue().maxItemCell +1)/2;
                    for (int k = 0; k < maxAnimalCell; k++) {
                        organisms.add(Organism.clone(pair.getValue()));
                    }
                    if(!organisms.isEmpty()){
                        animalMap[i][j].getAnimalsCell().put(pair.getValue().name, organisms);
                    }
                }

            }
        }
    }

    public static Cell[][] getAnimalMap() {
        return animalMap;
    }


}
