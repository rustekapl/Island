package ru.javarush.island.synckevich.enums;

public enum Action {
    MOVE(90),
    EAT(100),
    REPRODUCE(50),
    SLEEP(100);

    private final int actionChanceIndex;

    Action(int chanceIndex) {
        this.actionChanceIndex = chanceIndex;
    }

    public int getActionChanceIndex() {
        return this.actionChanceIndex;
    }
}
