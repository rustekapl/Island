package ru.javarush.island.ivanov.services.eat_services;

import ru.javarush.island.ivanov.entities.interfaces.WildLife;

public class CheckAmountOfConsumption {
    public static boolean enoughFood(WildLife eater, WildLife victim) {
        if (victim != null) {
            double foodNeeded = eater.getParams().getAmountOfFoodForSatiety();
            double foodFromVictim = victim.getParams().getWeight();
            return foodNeeded >= foodFromVictim;
        }
        return false;
    }
}
