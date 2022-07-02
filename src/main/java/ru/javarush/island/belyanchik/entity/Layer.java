package ru.javarush.island.belyanchik.entity;

import ru.javarush.island.belyanchik.enums.IslandParam;

public class Layer {
    private int bioTypeCode = 0; // биологический вид, соответствующий этому слою карты
    // слой ячеек карты
    private Cell[][] cells = new Cell[IslandParam.NUMBER_OF_COLUMNS][IslandParam.NUMBER_OF_ROWS];

    public Layer(int bioTypeCode, Cell[][] cells) {
        this.bioTypeCode = bioTypeCode;
        this.cells = cells;
    }


    public Cell[][] getCells() {
        return cells;
    }

    public Cell getCell(int row, int col) {
        return cells[row][col];
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }


    // сбор статистики по всем ячейкам слоя
    public int getLayerStat() {
        Cell[][] cells = this.getCells();
        int count = 0;
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                count += this.getCellStat(cells[row][col]);
            }
        }
        return count;
    }

    // сбор статистики по одной ячейке слоя
    public int getCellStat(Cell cell) {
        return cell.getOrganisms().getSize();
    }
}
