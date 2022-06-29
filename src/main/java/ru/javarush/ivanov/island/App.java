package ru.javarush.ivanov.island;

import ru.javarush.ivanov.island.entities.territory.Island;
import ru.javarush.ivanov.island.services.territory_services.IslandFiller;
import ru.javarush.ivanov.island.threads.IslandWorker;

public class App {
    public static void main(String[] args) {
        Island island = new Island(IslandFiller.getFilled());
        IslandWorker islandWorker = new IslandWorker(island);
        islandWorker.start();
    }
}
