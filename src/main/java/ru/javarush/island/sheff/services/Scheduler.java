package ru.javarush.island.sheff.services;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Scheduler extends Thread {

    private final ScheduledExecutorService scheduledExecutorService;
    private final GameLogicWorker gameLogicWorker;
    private final int period;

    public Scheduler(GameLogicWorker gameLogicWorker, int period) {
        this.scheduledExecutorService = Executors.newScheduledThreadPool(1);
        this.gameLogicWorker = gameLogicWorker;
        this.period = period;
    }

    @Override
    public void run() {
        scheduledExecutorService.scheduleAtFixedRate(gameLogicWorker, period, period, TimeUnit.SECONDS);
    }
}
