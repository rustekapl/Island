package ru.javarush.island.ivanov.entities.wildlife;


import org.jetbrains.annotations.NotNull;
import ru.javarush.island.ivanov.entities.Creature;
import ru.javarush.island.ivanov.entities.interfaces.Breedable;
import ru.javarush.island.ivanov.entities.interfaces.Eatable;
import ru.javarush.island.ivanov.entities.interfaces.Movable;
import ru.javarush.island.ivanov.entities.interfaces.WildLife;
import ru.javarush.island.ivanov.entities.territory.Square;
import ru.javarush.island.ivanov.services.move_services.CheckForMaxNumberAtSquare;
import ru.javarush.island.ivanov.services.move_services.NextSquare;
import ru.javarush.island.ivanov.services.randomizers.RandomizerForMoveDirection;
import ru.javarush.island.ivanov.variables.AnimalAndHerbsFactory;
import ru.javarush.island.ivanov.variables.ListOfAnimalsAndHerbs;
import ru.javarush.island.ivanov.variables.animal_params.AnimalParams;

import java.util.Set;

public abstract class Animal extends Creature implements WildLife, Eatable, Movable, Breedable {

    //TODO ---  protected??
    Square squareInfo;
    AnimalParams animalParams;

    @Override
    public boolean eat(Square square) {
        if (safeFindFood(square)) {
            return true;
        }
        return !safeDie(square);

    }

    @Override
    public boolean move(Square square) {
        int direction = RandomizerForMoveDirection.getResult();
        Square nextSquare = NextSquare.getNextSquare(this, direction);
        return safeMove(square, nextSquare);
    }

    @Override
    public boolean breed(Square square) {
        return safeBreed(square);
    }

    private boolean safeBreed(@NotNull Square square) {
        square.getLock().lock();
        try {
            Set<Creature> creatures = square.getResidents().get(getType());
            boolean checkForAmount = CheckForMaxNumberAtSquare.check(this);
            if (creatures.size() >= 2 && checkForAmount) {
                creatures.add(AnimalAndHerbsFactory.createWildLife(ListOfAnimalsAndHerbs.valueOf(this.getClass().getSimpleName().toUpperCase())));
                return true;
            }
        } finally {
            square.getLock().unlock();
        }
        return false;
    }
}
