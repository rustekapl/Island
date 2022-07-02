package ru.javarush.island.aleev.entity.map;


import ru.javarush.island.aleev.entity.organism.Organism;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Cell {

    //TODO ---  modofiers?
    int row;
    int col;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    //Делаем сет организмов
    public Map<String, Set<Organism>> residents = new HashMap<>();


    @Override
    public String toString() {
        return "\t|" + row + "/" + col + "|\t";
    }


}

