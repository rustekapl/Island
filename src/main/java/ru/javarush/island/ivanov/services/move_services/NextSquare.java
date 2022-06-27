package ru.javarush.island.ivanov.services.move_services;

import ru.javarush.island.ivanov.entities.Creature;
import ru.javarush.island.ivanov.entities.territory.Square;
import ru.javarush.island.ivanov.services.randomizers.RandomizerForMoveLength;
import ru.javarush.island.ivanov.variables.island_params.IslandWidthAndHeight;

public class NextSquare {
    public static Square getNextSquare(Creature currentUnit, int direction) {
        int rnd = RandomizerForMoveLength.getResult(currentUnit.getParams().getSpeed());
        Square square = currentUnit.getSquareInfo();
        Square result = square;
        boolean checkForAmount = CheckForMaxNumberAtSquare.check(currentUnit);
        //TODO Coding. Hard code. Not flexible
        switch (direction) {
            //TODO Coding. Magic values or methods. Bad reading and understanding
            case 1:
                int changedPosition = square.getSquareNumberHeight() - rnd;
                if (changedPosition >= 0 && checkForAmount) {
                    result = square.getTerritory()[square.getSquareNumberWidth()]
                            [changedPosition];
                    currentUnit.setSquareInfo(result);
                }
                break;

            case 2:
                changedPosition = square.getSquareNumberWidth() + rnd;
                if (changedPosition < IslandWidthAndHeight.getWidth() && checkForAmount) {
                    result = square.getTerritory()[changedPosition]
                            [square.getSquareNumberHeight()];
                    currentUnit.setSquareInfo(result);
                }
                break;

            case 3:
                changedPosition = square.getSquareNumberHeight() + rnd;
                if (changedPosition < IslandWidthAndHeight.getHeight() && checkForAmount) {
                    result = square.getTerritory()[square.getSquareNumberWidth()]
                            [changedPosition];
                    currentUnit.setSquareInfo(result);
                }
                break;

            case 4:
                changedPosition = square.getSquareNumberWidth() - rnd;
                if (changedPosition >= 0 && checkForAmount) {
                    result = square.getTerritory()[changedPosition]
                            [square.getSquareNumberHeight()];
                    currentUnit.setSquareInfo(result);
                }
                break;
        }
        return result;
    }
}
