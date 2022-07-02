package ru.javarush.island.ivanov.entities.territory;

public class Island {
    private final Square[][] islandTerritory;

    public Square[][] getIslandTerritory() {
        return islandTerritory;
    }

    public Island(Square[][] islandTerritory) {
        this.islandTerritory = islandTerritory;
    }

}
