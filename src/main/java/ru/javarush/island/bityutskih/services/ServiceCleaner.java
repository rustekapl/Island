package ru.javarush.island.bityutskih.services;

import ru.javarush.island.bityutskih.entity.Nature;
import ru.javarush.island.bityutskih.entity.Service;

import java.util.concurrent.CopyOnWriteArrayList;

public class ServiceCleaner implements Runnable {
    private final Service service;

    public ServiceCleaner(Service service) {
        this.service = service;
    }


    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        CopyOnWriteArrayList<Nature> nature = service.getNature();

        for (int i = 0; i < nature.size(); i++) {
            if (nature.get(i) != null && nature.get(i).isDead()) {
                nature.remove(i);
                i--;
            }
        }

    }
}

