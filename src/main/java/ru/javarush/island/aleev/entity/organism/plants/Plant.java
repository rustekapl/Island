package ru.javarush.island.aleev.entity.organism.plants;



import ru.javarush.island.aleev.entity.map.Cell;
import ru.javarush.island.aleev.parameters.Parameters;

public class Plant extends Plants {
    public Plant(Parameters parameters) {
        super(parameters);
    }





    @Override
    public boolean move(Cell curentCell) {
        return false;
    }
}
