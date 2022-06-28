package ru.javarush.island.ivanov.services.territory_services;

import ru.javarush.island.ivanov.variables.island_params.IslandWidthAndHeight;

public class IslandBuilder {

    public void letsBuild() {
        //TODO Coding. System.out here? Need remove to view layer
        System.out.println("Our Island");
        for (int i = 0; i < IslandWidthAndHeight.getHeight(); i++) {
            for (int j = 0; j < IslandWidthAndHeight.getWidth(); j++) {
                System.out.print("*");
            }
            System.out.println("*");
        }
    }


    public IslandBuilder() {
    }
}
