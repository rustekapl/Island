package ru.javarush.island.drogunov.view;

public interface View {
    String showStatistics();

    @SuppressWarnings("unused")
    //used for test
    String showMap();

    @SuppressWarnings("unused")
    //Used for test
    String showCountCellUnits();

    void showFinishMassage();
}
