package ru.javarush.island.aleev.parameters;


public class Parameters {
    private final String icon;
    private final int maxCount;
    private final int maxSpeed;

    public Parameters(String icon, int maxCount, int maxSpeed) {
        this.icon = icon;
        this.maxCount = maxCount;
        this.maxSpeed = maxSpeed;
    }


    public String getIcon() {
        return icon;
    }



    public int getMaxCount() {
        return maxCount;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }


}
