package ru.javarush.island.bulimov.entity;

import ru.javarush.island.bulimov.entity.repository.AnimalsFactory;
import ru.javarush.island.bulimov.islandMap.Island;
import ru.javarush.island.bulimov.view.ConsoleView;

import java.util.HashMap;


public class Game {



    private final Island island;
    private final HashMap<Integer,Organism> proto;
    private final ConsoleView view;


    public Game(Island island, HashMap<Integer,Organism> proto, ConsoleView view) {
        this.island = island;
        this.proto = proto;
        this.view = view;
    }
    public Island getIsland() {
        return island;
    }

    public  HashMap<Integer,Organism> getAnimalsFactory() {
        return proto;
    }

    public ConsoleView getView() {
        return view;
    }
}
