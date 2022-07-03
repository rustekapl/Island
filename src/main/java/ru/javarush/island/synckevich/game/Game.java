package ru.javarush.island.synckevich.game;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Game {
    public static final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);
    private final GameController controller;

    public Game() {
        GameField gameField = new GameField(GameSettings.WIDTH_MAP, GameSettings.HEIGHT_MAP);
        this.controller = new GameController(gameField);
    }

    public void start() {
        this.controller.getField().initialize();
        this.controller.getField().fill(GameSettings.MAX_ANIMAL_COUNT);
        executorService.scheduleWithFixedDelay(this.controller.getStats().createShowStatsTask(),
                100L, GameSettings.STAT_PERIOD, TimeUnit.MILLISECONDS);
        executorService.scheduleWithFixedDelay(this.controller.createLifeCycleTask(),
                100L, 100L, TimeUnit.MILLISECONDS);
        executorService.scheduleWithFixedDelay(this.controller.getField().createPlantGrowTask(),
                1000L, GameSettings.PLANT_GROW_TIME, TimeUnit.MILLISECONDS);
    }
}
