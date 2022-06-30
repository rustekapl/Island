package ru.javarush.island.hozhasaitov.app.service;

import ru.javarush.island.hozhasaitov.app.entity.map.Cell;
import ru.javarush.island.hozhasaitov.app.entity.map.GameMap;
import ru.javarush.island.hozhasaitov.app.entity.map.PrintMap;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameWorker extends Thread {
    private final Cell[][] gameMap;

    public GameWorker(Cell[][] gameMap) {
        this.gameMap = gameMap;
    }

    @Override
    public void run() {
        ScheduledExecutorService mainPool = Executors.newScheduledThreadPool(4);
        List<LineWorker> lineWorkers = Arrays.stream(gameMap)
                .map(LineWorker::new)
                .toList();
        mainPool.scheduleWithFixedDelay(() -> {
            ExecutorService executorService = Executors.newFixedThreadPool(4);
            lineWorkers.forEach(executorService::submit);
            executorService.shutdown();
            try {
                if (executorService.awaitTermination(1000, TimeUnit.DAYS)) {

                    PrintMap.printMap(GameMap.GAME_MAP.getMap());

                }
            } catch (InterruptedException e) {
                System.out.println("Что-то не так");
            }
        }, 1000, 1000, TimeUnit.MILLISECONDS);
    }
}
