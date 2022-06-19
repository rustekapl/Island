package com.javarush.island.khmelov.entity.organizms.animals;

import com.javarush.island.khmelov.entity.map.Cell;
import com.javarush.island.khmelov.entity.map.GameMap;
import com.javarush.island.khmelov.entity.organizms.Limit;
import com.javarush.island.khmelov.entity.organizms.animals.predators.Wolf;
import com.javarush.island.khmelov.repository.EntityFactory;
import com.javarush.island.khmelov.repository.GameMapCreator;
import org.junit.jupiter.api.Test;

class AnimalTest {

    @Test
    void move() {
        GameMap map = new GameMapCreator(new EntityFactory()).createRandomFilledGameMap(3, 3);
        Limit limit = new Limit(30, 40, 4, 6);
        new Wolf("testWolf", "w", limit);
        Cell[][] cells = map.getCells();

    }
}