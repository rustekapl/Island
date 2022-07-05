package ru.javarush.island.ryabov.view;

import ru.javarush.island.ryabov.entity.map.GameMap;

public interface View {
    void showStatistics();

    void allStats(GameMap gameMap);

}