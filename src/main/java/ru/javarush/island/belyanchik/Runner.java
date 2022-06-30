package ru.javarush.island.belyanchik;

import ru.javarush.island.belyanchik.entity.IslandMap;
import ru.javarush.island.belyanchik.servises.IslandMapWorker2;


//** Класс для запуска эмуляции
public class Runner {
    public static void main(String[] args) {
        IslandMap islandMap = null;
        try {
            //TODO Coding. System.out here? Need move the output to View layer
            System.out.println("Инициализация карты...");
            islandMap = new IslandMap(IslandMap.fillLayers());
            System.out.println("Инициализация карты завершена.");
            IslandMapWorker2 islandMapWorker = new IslandMapWorker2(islandMap);
            islandMapWorker.start();


        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}

