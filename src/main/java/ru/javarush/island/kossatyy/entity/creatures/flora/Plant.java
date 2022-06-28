package ru.javarush.island.kossatyy.entity.creatures.flora;

import ru.javarush.island.kossatyy.entity.creatures.Creature;

public abstract class Plant extends Creature {


    public Plant(String icon, int groupID, double weight) {
        super(icon, groupID, weight, false);
    }

}
