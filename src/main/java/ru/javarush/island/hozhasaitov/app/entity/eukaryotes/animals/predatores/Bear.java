package ru.javarush.island.hozhasaitov.app.entity.eukaryotes.animals.predatores;

import ru.javarush.island.hozhasaitov.app.constants.Constants;
import ru.javarush.island.hozhasaitov.app.constants.Diets;
import ru.javarush.island.hozhasaitov.app.interfaces.PredatoryAnimal;

public class Bear extends PredatoryAnimal {
    private static int count;


    public Bear() {
        super.weightMax = Constants.BEAR_WEIGHT;
        super.weight = weightMax;
        super.speed = 3;
        super.diet = Diets.DIET_BEAR;
        super.amountFod = 80;
        count++;
    }

    public int getCount() {
        return count;
    }

    public static void decrementCount() {
        count--;
    }

    @Override
    public void die() {
        super.die();
        System.out.println(weightMax);
    }
}
