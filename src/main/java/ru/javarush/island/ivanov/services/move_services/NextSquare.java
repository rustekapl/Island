package ru.javarush.island.ivanov.services.move_services;

import ru.javarush.island.ivanov.entities.Creature;
import ru.javarush.island.ivanov.variables.island_params.IslandWidthAndHeight;
import ru.javarush.island.ivanov.entities.territory.Square;
import ru.javarush.island.ivanov.services.randomizers.RandomizerForMoveLength;

public class NextSquare {
    public static Square getNextSquare(Creature currentUnit, Directions direction) {
        int rnd = RandomizerForMoveLength
                .getResult(currentUnit
                        .getParams()
                        .getSpeed());
        Square square = currentUnit.getSquareInfo();
        switch (direction) {
            case NORTH:
                int changedPosition = square.getSquareNumberHeight() - rnd;
                square = changePosition(currentUnit,square,changedPosition,false);
                break;

            case EAST:
                changedPosition = square.getSquareNumberWidth() + rnd;
                square = changePosition(currentUnit,square,changedPosition,true);
                break;

            case SOUTH:
                changedPosition = square.getSquareNumberHeight() + rnd;
                square = changePosition(currentUnit,square,changedPosition,false);
                break;

            case WEST:
                changedPosition = square.getSquareNumberWidth() - rnd;
                square = changePosition(currentUnit,square,changedPosition,true);
                break;
        }
        return square;
    }

    private static Square changePosition(Creature currentUnit, Square square, int changedPosition, boolean isWidthChanged) {
        boolean checkForAmount = CheckForMaxNumberAtSquare.checkForEnoughSpace(currentUnit);
        if (changedPosition < IslandWidthAndHeight.getWidth()
                && changedPosition >= 0
                && checkForAmount
                && isWidthChanged) {
            square = square.getTerritory()[changedPosition]
                    [square.getSquareNumberHeight()];
        } else if (changedPosition < IslandWidthAndHeight.getHeight()
                && changedPosition >= 0
                && checkForAmount
                && !isWidthChanged) {
            square = square.getTerritory()[square.getSquareNumberWidth()]
                    [changedPosition];
        }
        return square;
    }
}
