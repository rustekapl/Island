package ru.javarush.island.ivanov.services.territory_services;

import ru.javarush.island.ivanov.entities.Creature;
import ru.javarush.island.ivanov.entities.territory.Square;
import ru.javarush.island.ivanov.variables.ListOfAnimalsAndHerbs;
import ru.javarush.island.ivanov.variables.island_params.IslandWidthAndHeight;

import java.util.HashSet;
import java.util.Set;

public class IslandFiller {
    public static Square[][] getFilled() {
        int height = IslandWidthAndHeight.getHeight();
        int width = IslandWidthAndHeight.getWidth();
        Square[][] result = new Square[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Square square = new Square(i, j);
                square.setResidents(SquareFiller.getFilled());
                creatureInfoFiller(square);
                result[i][j] = square;
            }
        }
        territoryInfoFiller(result);
        return result;
    }

    private static void creatureInfoFiller(Square square) {
        Set<String> listOfAnimals = ListOfAnimalsAndHerbs.getCurrencies();
        for (String type : listOfAnimals) {
            //TODO Code style. Need reformat or extraction to methods | variables | constants
            Set<Creature> set = new HashSet<>(square.getResidents().get(type));
            set.forEach(c -> c.setSquareInfo(square));
        }
    }

    private static void territoryInfoFiller(Square[][] squares) {
        for (Square[] row : squares) {
            for (Square square : row) {
                square.setTerritory(squares);
            }
        }
    }

    //TODO Code style. Incorrect order members or modifiers
    private IslandFiller() {
    }
}
