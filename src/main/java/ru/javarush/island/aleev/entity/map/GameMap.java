package ru.javarush.island.aleev.entity.map;


import ru.javarush.island.aleev.cotstants.Constants;
import ru.javarush.island.aleev.entity.organism.Organism;
import ru.javarush.island.aleev.entity.organism.animals.carnivores.Bear;
import ru.javarush.island.aleev.entity.organism.animals.carnivores.Wolf;
import ru.javarush.island.aleev.entity.organism.animals.herbivores.Boar;
import ru.javarush.island.aleev.entity.organism.animals.herbivores.Horse;
import ru.javarush.island.aleev.entity.organism.plants.Plant;
import ru.javarush.island.aleev.parameters.Parameters;
import ru.javarush.island.aleev.utils.Randomizer;

import java.util.HashSet;
import java.util.Set;


public class GameMap {

    //TODO ---  static? why?
    public static Cell[][] cells = new Cell[2][2];


    //создаем массив ячеек игрового поля
    public void init() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }
    }

    //заполняем ячейки организмами
    int countBear;
    int countWolf;
    int countBoar;
    int countHorse;

    public void fill() {
        for (Cell[] cell : cells) {
            for (Cell item : cell) {
                //TODO Code style. Long code. Needs to be split into several methods

                //Делаем сет медведей
                Set<Organism> setBears = new HashSet<>();
                countBear = Randomizer.get(2, Constants.MAX_COUNT_BEAR);
                for (int k = 0; k < countBear; k++) {
                    setBears.add(new Bear(new Parameters(Constants.NAME_BEAR, Constants.BEAR_ICON,
                            Randomizer.get(Constants.MAX_WEIGHT_BEAR - Constants.MAX_FOOD_BEAR, Constants.MAX_WEIGHT_BEAR),
                            Constants.MAX_WEIGHT_BEAR, Constants.MAX_COUNT_BEAR, Constants.MAX_SPEED_BEAR, Constants.MAX_FOOD_BEAR)));
                }
                System.out.println(setBears);
                item.residents.put(Bear.class.getSimpleName(), setBears);

                //Делаем сет волков
                Set<Organism> setWolves = new HashSet<>();
                countWolf = Randomizer.get(2, Constants.MAX_COUNT_WOLF);
                for (int k = 0; k < countWolf; k++) {
                    setWolves.add(new Wolf(new Parameters(Constants.NAME_WOLF, Constants.WOLF_ICON,
                            Randomizer.get(Constants.MAX_WEIGHT_WOLF - Constants.MAX_FOOD_WOLF, Constants.MAX_WEIGHT_WOLF),
                            Constants.MAX_WEIGHT_WOLF, Constants.MAX_COUNT_WOLF, Constants.MAX_SPEED_WOLF, Constants.MAX_FOOD_WOLF)));
                }
                System.out.println(setWolves);
                item.residents.put(Wolf.class.getSimpleName(), setWolves);

                //Делаем сет кабанов
                Set<Organism> setBoars = new HashSet<>();
                countBoar = Randomizer.get(2, Constants.MAX_COUNT_BOAR);
                for (int k = 0; k < countBoar; k++) {
                    setBoars.add(new Boar(new Parameters(Constants.NAME_BOAR, Constants.BOAR_ICON,
                            Randomizer.get(Constants.MAX_WEIGHT_BOAR - Constants.MAX_FOOD_BOAR, Constants.MAX_WEIGHT_BOAR),
                            Constants.MAX_WEIGHT_BOAR, Constants.MAX_COUNT_BOAR, Constants.MAX_SPEED_BOAR, Constants.MAX_FOOD_BOAR)));
                }
                System.out.println(setBoars);
                item.residents.put(Boar.class.getSimpleName(), setBoars);

                //Делаем сет лошадей
                Set<Organism> setHorses = new HashSet<>();
                countHorse = Randomizer.get(2, Constants.MAX_COUNT_HORSE);
                for (int k = 0; k < countHorse; k++) {
                    setHorses.add(new Horse(new Parameters(Constants.NAME_HORSE, Constants.HORSE_ICON,
                            Randomizer.get(Constants.MAX_WEIGHT_HORSE - Constants.MAX_FOOD_HORSE, Constants.MAX_WEIGHT_HORSE),
                            Constants.MAX_WEIGHT_HORSE, Constants.MAX_COUNT_HORSE, Constants.MAX_SPEED_HORSE, Constants.MAX_FOOD_HORSE)));
                }
                System.out.println(setHorses);
                item.residents.put(Horse.class.getSimpleName(), setHorses);

                //Делаем сет растений
                Set<Organism> setPlants = new HashSet<>();
                for (int k = 0; k < Constants.MAX_COUNT_PLANT; k++) {
                    setPlants.add(new Plant(new Parameters(Constants.NAME_PLANT, Constants.PLANT_ICON,
                            Constants.MAX_WEIGHT_PLANT, Constants.MAX_WEIGHT_PLANT, Constants.MAX_COUNT_PLANT, 0, 0)));

                }
                //TODO Coding. System.out here? Need move the output to View layer
                System.out.println(setPlants);
                item.residents.put(Plant.class.getSimpleName(), setPlants);


                System.out.println("-----------------------------------------------------------------------------");


                item.residents.forEach((key, value) -> System.out.print(key + "=" + value.size() + " "));
                System.out.println("\n");
                System.out.println("=============================================================================");

//TODO --- Code style. Need always delete code. Not comment it.
////                int countBear;
////                int countWolf;
////                int countBoar;
////                int countHorse;
////                //Делаем сет организмов
////
////                //Делаем сет медведей
////                Set<Organism> setBears = new HashSet<>();
////                countBear = Randomizer.get(2, Constants.MAX_COUNT_BEAR);
////                for (int k = 0; k < countBear; k++) {
////                    setBears.add(new Bear(new Parameters(Constants.NAME_BEAR, Constants.BEAR_ICON,
////                            Randomizer.get(Constants.MAX_WEIGHT_BEAR - Constants.MAX_FOOD_BEAR, Constants.MAX_WEIGHT_BEAR),
////                            Constants.MAX_WEIGHT_BEAR, Constants.MAX_COUNT_BEAR, Constants.MAX_SPEED_BEAR, Constants.MAX_FOOD_BEAR)));
////                }
////                System.out.println(setBears);
////                cells[i][j].residents.put(Bear.class.getSimpleName(),setBears);
////
////                //Делаем сет волков
////                Set<Organism> setWolves = new HashSet<>();
////                countWolf = Randomizer.get(2, Constants.MAX_COUNT_WOLF);
////                for (int k = 0; k < countWolf; k++) {
////                    setWolves.add(new Wolf(new Parameters(Constants.NAME_WOLF, Constants.WOLF_ICON,
////                            Randomizer.get(Constants.MAX_WEIGHT_WOLF - Constants.MAX_FOOD_WOLF, Constants.MAX_WEIGHT_WOLF),
////                            Constants.MAX_WEIGHT_WOLF, Constants.MAX_COUNT_WOLF, Constants.MAX_SPEED_WOLF, Constants.MAX_FOOD_WOLF)));
////                }
////                System.out.println(setWolves);
////                cells[i][j].residents.put(Wolf.class.getSimpleName(),setWolves);
////
////                //Делаем сет кабанов
////                Set<Organism> setBoars = new HashSet<>();
////                countBoar = Randomizer.get(2, Constants.MAX_COUNT_BOAR);
////                for (int k = 0; k < countBoar; k++) {
////                    setBoars.add(new Boar(new Parameters(Constants.NAME_BOAR, Constants.BOAR_ICON,
////                            Randomizer.get(Constants.MAX_WEIGHT_BOAR - Constants.MAX_FOOD_BOAR, Constants.MAX_WEIGHT_BOAR),
////                            Constants.MAX_WEIGHT_BOAR, Constants.MAX_COUNT_BOAR, Constants.MAX_SPEED_BOAR, Constants.MAX_FOOD_BOAR)));
////                }
////                System.out.println(setBoars);
////                cells[i][j].residents.put(Boar.class.getSimpleName(),setBoars);
////
////                //Делаем сет лошадей
////                Set<Organism> setHorses = new HashSet<>();
////                countHorse = Randomizer.get(2, Constants.MAX_COUNT_HORSE);
////                for (int k = 0; k < countHorse; k++) {
////                    setHorses.add(new Horse(new Parameters(Constants.NAME_HORSE, Constants.HORSE_ICON,
////                            Randomizer.get(Constants.MAX_WEIGHT_HORSE - Constants.MAX_FOOD_HORSE, Constants.MAX_WEIGHT_HORSE),
////                            Constants.MAX_WEIGHT_HORSE, Constants.MAX_COUNT_HORSE, Constants.MAX_SPEED_HORSE, Constants.MAX_FOOD_HORSE)));
////                }
////                System.out.println(setHorses);
////                cells[i][j].residents.put(Horse.class.getSimpleName(),setHorses);
////
////                //Делаем сет растений
////                Set<Organism> setPlants = new HashSet<>();
////                for (int k = 0; k < Constants.MAX_COUNT_PLANT; k++) {
////                    setPlants.add(new Plant(new Parameters(Constants.NAME_PLANT, Constants.PLANT_ICON,
////                            Constants.MAX_WEIGHT_PLANT, Constants.MAX_WEIGHT_PLANT, Constants.MAX_COUNT_PLANT, 0, 0)));
////
////                }
////                System.out.println(setPlants);
////                cells[i][j].residents.put(Plant.class.getSimpleName(),setPlants);
////
////                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
////
//
//                //печатаем состав ячейки
////                Map<String, Integer> counter = new HashMap<>();
////                for (Organism organism :
////                        set) {
////                    int count = counter.getOrDefault(organism.getClass().getSimpleName(), 0) + 1;
////
////                    counter.put(organism.getClass().getSimpleName(), count);
////                }
////                System.out.println(set.size() + " : " + counter);
////                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//
//
            }
        }
    }

    // вывод на экран карты
    public void print() {
        for (Cell[] cell : cells) {
            for (Cell value : cell) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public void printInfo() {
        for (Cell[] cell : cells) {
            for (Cell item : cell) {
                System.out.print(item + "\t");
                item.residents.forEach((key, value) -> System.out.print(key + "=" + value.size() + " "));
                System.out.println("\n");

            }
        }
    }


}



