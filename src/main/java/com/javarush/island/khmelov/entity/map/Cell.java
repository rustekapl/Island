package com.javarush.island.khmelov.entity.map;

import com.javarush.island.khmelov.entity.organizms.Organism;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
@RequiredArgsConstructor
public class Cell {

    private final Map<Type, Set<Organism>> residents;

    private List<Cell> nextCell;
    private final Lock lock = new ReentrantLock(true);

}
