package ru.javarush.island.hozhasaitov.app.entity.map;


import ru.javarush.island.hozhasaitov.app.entity.eukaryotes.animals.herbivorous.Boar;
import ru.javarush.island.hozhasaitov.app.entity.eukaryotes.animals.predatores.Bear;

import java.util.concurrent.ThreadLocalRandom;

public class InitializeMap {

    private InitializeMap() {
    }

    public static void initializeMap(Cell[][] cells) {

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new Cell();
//                fill(cells[i][j]);

            }
        }


    }

    private static void fill(Cell cell) {
        int random = ThreadLocalRandom.current().nextInt(0, 100);
        if (random < 50) {
            cell.addEukaryote(new Bear());
        } else {
            cell.addEukaryote(new Boar());
        }
    }
}
