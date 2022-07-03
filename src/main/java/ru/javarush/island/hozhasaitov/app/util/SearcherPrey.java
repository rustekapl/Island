package ru.javarush.island.hozhasaitov.app.util;

import ru.javarush.island.hozhasaitov.app.entity.eukaryotes.animals.Animal;
import ru.javarush.island.hozhasaitov.app.entity.map.Cell;
import ru.javarush.island.hozhasaitov.app.interfaces.PredatoryAnimal;

public class SearcherPrey {

    private SearcherPrey() {
    }

    public static int searchPreyLine(Animal animal, Cell[] line, boolean isLineX) {
        int start = line.length % 2 == 0 ? line.length / 2 : line.length / 2 + 1;
        return foundPrey(animal, line, start, isLineX);

    }

    private static int foundPrey(Animal animal, Cell[] line,
                                 int start, boolean isLineX) {
        int startCount = start;
        if (animal instanceof PredatoryAnimal) {
            while (startCount < line.length) {
                if (line[startCount].getHerbivorousAnimals().size() != 0) {
//                    removeAnimal(animal, coorX, coorY, off, startCount, thisX);
                    return startCount;
                }
                startCount++;
            }

            startCount = start - 1;

            while (startCount >= 0) {
                if (line[startCount].getHerbivorousAnimals().size() != 0) {
//                        removeAnimal(animal, coorX, coorY, off, startCount, thisX);
                    return startCount;
                }
                startCount--;
            }


        } else {
            while (startCount < line.length) {
                if (line[startCount].getPlants().size() != 0) {
//                    removeAnimal(animal, coorX, coorY, off, startCount, thisX);
                    return startCount;
                }
                startCount++;
            }
            startCount = start - 1;

            while (startCount >= 0) {
                if (line[startCount].getPlants().size() != 0) {
//                        removeAnimal(animal, coorX, coorY, off, startCount, thisX);
                    return startCount;

                }
                startCount--;
            }


        }
        if (isLineX) {
            return animal.getCoorX();
        }
        return animal.getCoorY();
    }

}
