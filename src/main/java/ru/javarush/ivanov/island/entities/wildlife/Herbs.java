package ru.javarush.ivanov.island.entities.wildlife;

import org.jetbrains.annotations.NotNull;
import ru.javarush.ivanov.island.entities.Creature;
import ru.javarush.ivanov.island.entities.interfaces.WildLife;
import ru.javarush.ivanov.island.entities.territory.Square;
import ru.javarush.ivanov.island.services.move_services.CheckForMaxNumberAtSquare;
import ru.javarush.ivanov.island.variables.AnimalAndHerbsFactory;
import ru.javarush.ivanov.island.variables.ListOfAnimalsAndHerbs;
import ru.javarush.ivanov.island.variables.animal_params.AnimalParams;

import java.util.Set;

public class Herbs extends Creature implements WildLife {
    private final AnimalParams herbsParams = new AnimalParams();
    private Square squareInfo;

    public Herbs() {
        herbsParams.setWeight(1);
        herbsParams.setMaxNumberPerSquare(200);
        herbsParams.setSpeed(0);
        herbsParams.setAmountOfFoodForSatiety(0);
    }

    @Override
    public AnimalParams getParams() {
        return herbsParams;
    }

    @Override
    public Square getSquareInfo() {
        return squareInfo;
    }

    @Override
    public void setSquareInfo(Square squareInfo) {
        this.squareInfo = squareInfo;
    }

    @Override
    public boolean breed(Square square) {
        return safeBreed(square);
    }

    private boolean safeBreed(@NotNull Square square) {
        square.getLock().lock();
        try {
            Set<Creature> herbs = square.getResidents().get(getType());
            boolean checkForAmount = CheckForMaxNumberAtSquare.checkForEnoughSpace(this);
            if (herbs.size() >= 2 && checkForAmount) {
                herbs.add(AnimalAndHerbsFactory.createWildLife(ListOfAnimalsAndHerbs.valueOf(this.getClass().getSimpleName().toUpperCase())));
                return true;
            }
        } finally {
            square.getLock().unlock();
        }
        return false;
    }
}
