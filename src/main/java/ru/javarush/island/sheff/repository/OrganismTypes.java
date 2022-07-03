package ru.javarush.island.sheff.repository;

import ru.javarush.island.sheff.entities.organisms.animals.herbivores.*;
import ru.javarush.island.sheff.entities.organisms.animals.predators.*;
import ru.javarush.island.sheff.entities.organisms.plants.Plant;
import lombok.Getter;

import java.lang.reflect.Type;

@Getter
public enum OrganismTypes {

    BEAR("Bear", "\uD83D\uDC3B", Bear.class),
    BOA("Boa", "\uD83D\uDC0D", Boa.class),
    BOAR("Boar", "\uD83D\uDC17", Boar.class),
    BUFFALO("Buffalo", "\uD83D\uDC03", Buffalo.class),
    CATERPILLAR("Caterpillar", "\uD83D\uDC1B", Caterpillar.class),
    DEER("Deer", "\uD83E\uDD8C", Deer.class),
    DUCK("Duck", "\uD83E\uDD86", Duck.class),
    EAGLE("Eagle", "\uD83E\uDD85", Eagle.class),
    FOX("Fox", "\uD83E\uDD8A", Fox.class),
    GOAT("Goat", "\uD83D\uDC10", Goat.class),
    HORSE("Horse", "\uD83D\uDC0E", Horse.class),
    MOUSE("Mouse", "\uD83D\uDC01", Mouse.class),
    PLANT("Plant", "\uD83C\uDF3F", Plant.class),
    RABBIT("Rabbit", "\uD83D\uDC07", Rabbit.class),
    SHEEP("Sheep", "\uD83D\uDC11", Sheep.class),
    WOLF("Wolf", "\uD83D\uDC3A", Wolf.class);

    private final String name;
    private final String icon;
    private final Type type;

    OrganismTypes(String name, String icon, Type type) {
        this.name = name;
        this.icon = icon;
        this.type = type;
    }
}
