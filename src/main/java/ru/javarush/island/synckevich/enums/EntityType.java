package ru.javarush.island.synckevich.enums;

public enum EntityType {
    //TODO ---  only icon ???  Enum - good as type and as container for data and methods
    WOLF("\ud83d\udc01"),
    SNAKE("\ud83d\udc0d"),
    FOX("\ud83e\udd8a"),
    BEAR("\ud83d\udc3b"),
    EAGLE("\ud83e\udd85"),
    HORSE("\ud83d\udc0e"),
    DEER("\ud83e\udd8c"),
    RABBIT("\ud83d\udc07"),
    MOUSE("\ud83d\udc01"),
    GOAT("\ud83d\udc10"),
    SHEEP("\ud83d\udc11"),
    BOAR("\ud83d\udc17"),
    BUFFALO("\ud83d\udc03"),
    DUCK("\ud83e\udd86"),
    CATERPILLAR("\ud83d\udc1b"),
    PLANT("\ud83c\udf31");

    private final String unicodeSymbol;

    EntityType(String unicodeSymbol) {
        this.unicodeSymbol = unicodeSymbol;
    }

    public String getUnicodeSymbol() {
        return this.unicodeSymbol;
    }
}
