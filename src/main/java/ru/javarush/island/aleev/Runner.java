package ru.javarush.island.aleev;


import ru.javarush.island.aleev.entity.map.GameMap;
import ru.javarush.island.aleev.exception.GameException;

public class Runner {

    public static void main(String[] args) {
        GameMap gameMap = new GameMap();
        gameMap.init();
        gameMap.fill();
        gameMap.printInfo();

        while (true){
            gameMap.life();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
                throw new GameException(e);
            }
                gameMap.printInfo();
        }


    }


}

