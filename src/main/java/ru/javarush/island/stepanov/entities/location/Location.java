package ru.javarush.island.stepanov.entities.location;

import ru.javarush.island.stepanov.utils.RandomGenerator;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public class Location {

    private Coord size;
    private LocationCell[][] locationMatrix;

    public Location(int width, int height){
        this.size = new Coord(width, height);
        this.locationMatrix = new LocationCell[size.getWidth()][size.getHeight()];

        for (int i = 0; i < size.getWidth(); i++) {
            for (int j = 0; j < size.getHeight(); j++) {
                locationMatrix[i][j] = new LocationCell(new Coord(i, j));
            }
        }
    }

    public Coord getRandomCoordinate(){
        return new Coord(
                RandomGenerator.get(size.getWidth()),
                RandomGenerator.get(size.getHeight())
        );
    }

    public List<LocationCell> getCellsPool(){
        return Arrays.stream(locationMatrix)
                .flatMap(Arrays::stream)
                .toList();
    }

    public List<LocationCell> getCellsAround(LocationCell locationCell){
        List<LocationCell> cellsAround = new ArrayList<>();

        int cellWidth = locationCell.getCoordinate().getWidth();
        int cellHeight = locationCell.getCoordinate().getHeight();

        for (int width = -1; width < 2; width++) {
            for (int height = -1; height < 2; height++) {
                try{
                    LocationCell cell = this.locationMatrix[cellWidth + width][cellHeight + height];
                    if (!(cell.equals(locationCell))){
                        cellsAround.add(cell);
                    }
                } catch (ArrayIndexOutOfBoundsException e){
                    continue;
                }
            }
        }
        return cellsAround;
    }
}
