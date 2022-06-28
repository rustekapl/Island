package ru.javarush.island.khryukin;

import ru.javarush.island.khryukin.entity.Game;
import ru.javarush.island.khryukin.entity.map.GameMap;
import ru.javarush.island.khryukin.factory.EntityFactory;
import ru.javarush.island.khryukin.factory.Factory;
import ru.javarush.island.khryukin.factory.GameMapCreator;
import ru.javarush.island.khryukin.property.Setting;
import ru.javarush.island.khryukin.services.GameWorker;
import ru.javarush.island.khryukin.view.ConsoleView;
import ru.javarush.island.khryukin.view.View;


public class ConsoleRunner {

    public static void main(String[] args) {
        Factory entityFactory = new EntityFactory();
        GameMapCreator gameMapCreator = new GameMapCreator(entityFactory);
        GameMap gameMap = gameMapCreator.createRandomFilledGameMap(Setting.MAP_ROWS, Setting.MAP_COLS);
        View view = new ConsoleView(gameMap);
        Game game = new Game(gameMap, entityFactory, view);
        /*ru.javarush.island.khryukin.view.showMap();
        ru.javarush.island.khryukin.view.showStatistics();
        Cell[][] cells = gameMap.getCells();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                Map<Type, Set<Organism>> org = cells[i][j].getResidents();
                for (Set<Organism> organism : org.values()) {
                    for (Organism or : organism) {
                        if(or instanceof Animal animal){
                            animal.move(cells[i][j]);
                        }
                    }
                }
            }
        }
        ru.javarush.island.khryukin.view.showMap();
        ru.javarush.island.khryukin.view.showStatistics();*/
        GameWorker gameWorker = new GameWorker(game);
        gameWorker.start();
    }
}
