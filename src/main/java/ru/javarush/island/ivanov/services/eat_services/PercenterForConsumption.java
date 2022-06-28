package ru.javarush.island.ivanov.services.eat_services;


import ru.javarush.island.ivanov.variables.ListOfAnimalsAndHerbs;
import ru.javarush.island.ivanov.variables.consume_lists_factory.ChanceToConsumeFactory;
import ru.javarush.island.ivanov.variables.consume_lists_factory.ChanceToConsumeList;


public class PercenterForConsumption {

    public int getPercents(String firstClazz, String secondClazz) {
        if (firstClazz != null && secondClazz != null) {
            ListOfAnimalsAndHerbs first = ListOfAnimalsAndHerbs.valueOf(firstClazz.toUpperCase());
            ChanceToConsumeList chanceToConsumeList = ChanceToConsumeFactory.createConsumeList(first);
            return chanceToConsumeList.getListOfPercents().get(secondClazz);
        }
        return 0;
    }

}
