package com.javarush.island.khmelov.services.tasks;

import com.javarush.island.khmelov.entity.map.Cell;
import com.javarush.island.khmelov.entity.map.GameMap;
import com.javarush.island.khmelov.entity.organizms.Limit;
import com.javarush.island.khmelov.entity.organizms.Organism;
import com.javarush.island.khmelov.entity.organizms.animals.predators.Wolf;
import com.javarush.island.khmelov.repository.EntityFactory;
import com.javarush.island.khmelov.repository.Factory;
import com.javarush.island.khmelov.repository.GameMapCreator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;

class TaskTest {

    private GameMap map;
    private Wolf wolf;
    private Cell startCell;
    private double delta;

    @BeforeEach
    void map() {
        Factory factory = new EntityFactory();
        GameMapCreator creator = new GameMapCreator(factory);
        map = creator.createRandomFilledGameMap(3, 3, true);
        Limit limit = new Limit(100, 2, 1, 1);
        wolf = new Wolf("testWolf", "W", limit);
        Cell[][] cells = map.getCells();
        startCell = cells[0][0];
        Map<String, Set<Organism>> residents = startCell.getResidents();
        residents.get(wolf.getType()).add(wolf);
    }

    @Test
    void bornClone() {
        Assertions.assertFalse(startCell.getResidents().get(wolf.getType()).isEmpty());
        int count = 5;
        Task.bornClone(wolf, startCell, count).run();
        Assertions.assertEquals(count + 1, startCell.getResidents().get(wolf.getType()).size());
    }

    @Test
    void die() {
        Assertions.assertFalse(startCell.getResidents().get(wolf.getType()).isEmpty());
        Task.die(wolf, startCell).run();
        Assertions.assertTrue(startCell.getResidents().get(wolf.getType()).isEmpty());
    }

    @Test
    void slim() {
        double expected = wolf.getWeight() - wolf.getLimit().getMaxWeight() * 0.1;
        Task.slim(wolf, startCell, 10).run();
        Assertions.assertEquals(expected, wolf.getWeight());
    }

    @Test
    void move() {
    }
}