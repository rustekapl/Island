package ru.javarush.ivanov.island.services.eat_services;

import ru.javarush.ivanov.island.entities.interfaces.WildLife;

public class CheckAmountOfConsumption {
    public static boolean enoughFood(WildLife eater, WildLife victim) {
        if (victim != null) {
            double foodNeeded = eater
                    .getParams()
                    .getAmountOfFoodForSatiety();
            double foodFromVictim = victim
                    .getParams()
                    .getWeight();
            return foodNeeded >= foodFromVictim;
        }
        return false;
    }
}
