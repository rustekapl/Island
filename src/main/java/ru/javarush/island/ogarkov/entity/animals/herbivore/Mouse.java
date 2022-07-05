package ru.javarush.island.ogarkov.entity.animals.herbivore;

import ru.javarush.island.ogarkov.annotations.ItemData;
import ru.javarush.island.ogarkov.settings.Setting;

@ItemData(
        name = "Мышь",
        maxWeight = 0.05,
        maxCount = 500,
        maxSpeed = 1,
        maxFood = 0.01,
        icon = "/ogarkov/herbivore/mouse.png"
)
public class Mouse extends HerbivoreAnimal {
    public Mouse() {
        chanceToReproduce = Setting.HIGHER_CHANCE_TO_REPRODUCE;
    }
}
