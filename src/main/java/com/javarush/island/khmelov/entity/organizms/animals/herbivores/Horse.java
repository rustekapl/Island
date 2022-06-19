package com.javarush.island.khmelov.entity.organizms.animals.herbivores;

import com.javarush.island.khmelov.abstraction.annotations.Setting;
import com.javarush.island.khmelov.entity.organizms.Limit;
import lombok.RequiredArgsConstructor;

@Setting(name = "Лошадка", icon = "\uD83D\uDC0E", maxWeight = 400, maxCount = 20, maxSpeed = 4, maxFood = 60)
public class Horse extends Herbivore {
    public Horse(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }

}
