package com.javarush.island.khmelov.entity;

import com.javarush.island.khmelov.entity.map.GameMap;
import com.javarush.island.khmelov.repository.EntityFactory;
import com.javarush.island.khmelov.view.View;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Game {

    private final GameMap gameMap;
    private final EntityFactory entityFactory;
    private final View view;

}
