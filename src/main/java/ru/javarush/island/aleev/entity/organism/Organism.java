package ru.javarush.island.aleev.entity.organism;


import ru.javarush.island.aleev.cotstants.Constants;
import ru.javarush.island.aleev.cotstants.OrganismType;
import ru.javarush.island.aleev.entity.map.Cell;
import ru.javarush.island.aleev.entity.map.GameMap;
import ru.javarush.island.aleev.exception.GameException;
import ru.javarush.island.aleev.parameters.Parameters;
import ru.javarush.island.aleev.utils.Randomizer;

import java.util.concurrent.ThreadLocalRandom;


public abstract class Organism implements Cloneable {
    private final String icon;
    private final int maxSpeed;


    public Organism(Parameters parameters) {
        this.icon = parameters.getIcon();
        this.maxSpeed = parameters.getMaxSpeed();
    }


    public boolean move(Cell curentCell) {
        //calculate targetCell
        int targetRow = curentCell.getRow() + Randomizer.get(0, this.maxSpeed);
        int targetCol = curentCell.getCol() + Randomizer.get(0, this.maxSpeed);
        boolean isMove = ThreadLocalRandom.current().nextBoolean();

        System.out.println("isMove " + isMove);

        //check if new coordinates out of map
        if(targetRow<0||targetCol<0){
          isMove=false;
        }

        if(targetRow> Constants.WIDTH_ISLAND){
            targetRow=(targetCol%Constants.WIDTH_ISLAND)-1;
        }
        if(targetCol>Constants.LENGTH_ISLAND){
            targetCol=(targetCol%Constants.LENGTH_ISLAND)-1;
        }
//        if (targetRow >= Constants.WIDTH_ISLAND || targetCol >= Constants.LENGTH_ISLAND || targetRow < 0 || targetCol < 0) {
//            isMove = false;
//        }

        //move Animal
        if (isMove) {
            GameMap.cells[targetRow][targetCol].resident.get(OrganismType.valueOf(this.getClass().getSimpleName().toUpperCase())).add(this);
        }

        return isMove;
    }

    @Override
    public String toString() {
        return icon;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new GameException("not found Entity constructor", e);
        }
    }




}
