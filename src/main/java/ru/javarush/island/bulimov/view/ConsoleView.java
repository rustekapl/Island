package ru.javarush.island.bulimov.view;

import ru.javarush.island.bulimov.islandMap.Cell;
import ru.javarush.island.bulimov.islandMap.Island;
import ru.javarush.island.bulimov.settings.OrganismSetting;

import java.util.HashMap;
import java.util.Map;

public class ConsoleView {

    public  void viewShow(){
        System.out.println("**************************** Выполняется такт *******************************");
        for (Map.Entry<String, Integer> pair : getMap().entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
        System.out.println("****************************** Такт окончен *********************************");
    }

    public HashMap<String, Integer> getMap(){
        HashMap<String, Integer> viewMap = new HashMap<>();
        for (Cell[] row : Island.getAnimalMap()) {
            for (Cell cell : row) {
                for (String name : OrganismSetting.getNames()) {
                    if(cell.getAnimalsCell().get(name) != null && viewMap.get(name) == null){
                        viewMap.put(name, cell.getAnimalsCell().get(name).size());
                    }
                    if(cell.getAnimalsCell().get(name) != null && viewMap.get(name) != null){
                        viewMap.put(name,viewMap.get(name) + cell.getAnimalsCell().get(name).size());
                    }
                }

            }
        }
        return viewMap;
    }
}
