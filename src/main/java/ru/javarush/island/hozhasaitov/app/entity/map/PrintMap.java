package ru.javarush.island.hozhasaitov.app.entity.map;

public class PrintMap {
    private PrintMap() {
    }

    public static void printMap(Cell[][] cells) {
//        Arrays.stream(fields).forEach(
//                f -> {
//                    Arrays.stream(f).forEach(
//                        s -> System.out.print(s.getRelief().getImage()));
//                System.out.println();
//                });

        for (Cell[] cell : cells) {
            for (int j = 0; j < cell.length; j++) {
                System.out.print(cell[j].getView());
            }
            System.out.println();
        }
        System.out.println("-----------------------------");
    }
}
