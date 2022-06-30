package ru.javarush.island.aleev;


import ru.javarush.island.aleev.entity.map.GameMap;

public class Runner {

    public static void main(String[] args) {
        GameMap gameMap = new GameMap();
        gameMap.init();
        gameMap.print();
        System.out.println("*****************************************************************************");
        gameMap.fill();
        gameMap.printInfo();
//
//        System.out.println(GameMap.cells[0][0].residents.get("Plant").size());
//        GameMap.cells[0][0].residents.forEach((key, value) -> System.out.print(key + "=" + value.size() + " "));
//        System.out.println("");
//        System.out.println(GameMap.cells[0][0].residents.get("Bear"));
//        System.out.println(GameMap.cells[0][0].residents.get("Wolf"));
//        System.out.println(GameMap.cells[0][0].residents.get("Boar"));
//        System.out.println(GameMap.cells[0][0].residents.get("Horse"));
//        List<Plants> plants = new ArrayList<>();
//        List<Herbivore> herbivores = new ArrayList<>();
//        List<Carnivore> carnivores = new ArrayList<>();
//        for(String key: GameMap.cells[0][0].residents.keySet()){
//            System.out.println("Ключ: "+key+" = "+ GameMap.cells[0][0].residents.get(key).size());
//            System.out.println();
//        }
//
//        for(String key: GameMap.cells[0][0].residents.keySet()) {
//            if (key.equals("Plant")) {
//                plants.add((Plants) GameMap.cells[0][0].residents.get(key));
//            }
//            if (key.equals("Boar") || key.equals("Horse")) {
//                herbivores.add((Herbivore) GameMap.cells[0][0].residents.get(key));
//            }
//            if (key.equals("Bear") || key.equals("Wolf")) {
//                carnivores.add((Carnivore) GameMap.cells[0][0].residents.get(key));
//            }
//        }
//        System.out.println("____________________________________________________________");
//        System.out.println(plants);
//        System.out.println(herbivores);
//        System.out.println(carnivores);
    }


}

