package ru.javarush.island.ivanov.services.randomizers;

import ru.javarush.island.ivanov.entities.Creature;
import ru.javarush.island.ivanov.variables.ListOfAnimalsAndHerbs;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomizerForType {

    public static String getRandomType(Creature creature) {
        List<String> stringList = ListOfAnimalsAndHerbs.getCurrencies().stream().toList();
        String result = "";
        int rnd = ThreadLocalRandom.current().nextInt(0, stringList.size());
        String s = stringList.get(rnd);
        if (!s.equals(creature.getType())) {
            result = s;
        }
        return result;
    }

    private RandomizerForType() {
    }
}
