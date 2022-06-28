package ru.javarush.island.kolontsov.gamefield;

public class GameField {

    Cell[][] field = new Cell[100][20];

    public void initialize() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = new Cell(i, j);
            }
        }
    }

}
