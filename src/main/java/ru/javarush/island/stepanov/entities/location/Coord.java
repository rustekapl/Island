package ru.javarush.island.stepanov.entities.location;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Coord {

    @EqualsAndHashCode.Include()
    private int width;
    @EqualsAndHashCode.Include()
    private int height;

    public Coord(int width, int height){
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "{" + width + ";" + height + "}";
    }
}
