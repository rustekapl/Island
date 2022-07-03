package ru.javarush.island.nikolaev.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.javarush.island.nikolaev.entity.map.Cell;
import ru.javarush.island.nikolaev.entity.map.GameMap;
import ru.javarush.island.nikolaev.repository.Factory;
import ru.javarush.island.nikolaev.view.View;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Game {

    private final GameMap gameMap;
    private final Factory entityFactory;
    private final View view;
    private final List<Cell> nextCell = new ArrayList<>();

}
