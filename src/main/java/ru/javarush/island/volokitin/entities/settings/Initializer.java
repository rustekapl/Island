package ru.javarush.island.volokitin.entities.settings;

import ru.javarush.island.volokitin.creators.WorldCreator;
import ru.javarush.island.volokitin.entities.world.World;

public class Initializer {
    public World createWorld() {
        WorldCreator worldCreator = new WorldCreator();
        return worldCreator.createWorld();
    }
}
