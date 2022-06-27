package ru.javarush.island.ivanov;

import ru.javarush.island.ivanov.entities.territory.Island;
import ru.javarush.island.ivanov.services.territory_services.IslandFiller;
import ru.javarush.island.ivanov.threads.IslandWorker;

public class App {
    public static void main(String[] args) {
        Island island = new Island(IslandFiller.getFilled());
        IslandWorker islandWorker = new IslandWorker(island);
        islandWorker.start();
    }
}
