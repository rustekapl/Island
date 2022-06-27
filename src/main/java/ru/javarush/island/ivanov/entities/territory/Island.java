package ru.javarush.island.ivanov.entities.territory;

public class Island {
    private Square[][] islandTerritory;

    public Square[][] getIslandTerritory() {
        return islandTerritory;
    }

    //TODO Code style. Many warnings. Skip or fix it.
    public void setIslandTerritory(Square[][] islandTerritory) {
        this.islandTerritory = islandTerritory;
    }

    public Island(Square[][] islandTerritory) {
        this.islandTerritory = islandTerritory;
    }

}
