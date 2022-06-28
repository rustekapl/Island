package ru.javarush.island.drogunov.enity.plants.view_plants;

import ru.javarush.island.drogunov.enity.annotations.Populations;
import ru.javarush.island.drogunov.enity.plants.Plant;

@Populations(max = 200)
public class SimplePlant extends Plant {

    public SimplePlant(int x, int y) {
        super(x, y);
    }
}
