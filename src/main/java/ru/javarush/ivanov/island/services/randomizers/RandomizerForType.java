package ru.javarush.ivanov.island.services.randomizers;

import ru.javarush.ivanov.island.entities.Creature;
import ru.javarush.ivanov.island.variables.ListOfAnimalsAndHerbs;

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
