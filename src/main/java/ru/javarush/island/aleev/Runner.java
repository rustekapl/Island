package ru.javarush.island.aleev;


import ru.javarush.island.aleev.entity.map.GameMap;
import ru.javarush.island.aleev.exception.GameException;

public class Runner {

    public static void main(String[] args) {
        GameMap gameMap = new GameMap();
        gameMap.init();
        gameMap.fill();
        gameMap.printInfo();
        //TODO Code style. Many warnings. Skip or fix it.
        while (true){
            gameMap.life();
            try {
                //TODO Coding. Magic values or methods. Bad reading and understanding
                Thread.sleep(1000);
            } catch (InterruptedException e){
                throw new GameException(e);
            }
                gameMap.printInfo();
        }

    }


}

