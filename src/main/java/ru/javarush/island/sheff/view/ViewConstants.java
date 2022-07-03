package ru.javarush.island.sheff.view;

public enum ViewConstants {

    STEP_PREFIX("Day: "),
    POPULATION_PREFIX("Population: "),
    TITLE("Island Simulation");

    private final String name;

    ViewConstants(String s) {
        name = s;
    }

    public String toString() {
        return this.name;
    }
}
