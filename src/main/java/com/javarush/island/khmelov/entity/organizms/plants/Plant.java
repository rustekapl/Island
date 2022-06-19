package com.javarush.island.khmelov.entity.organizms.plants;

import com.javarush.island.khmelov.abstraction.annotations.Setting;
import com.javarush.island.khmelov.entity.organizms.Limit;
import com.javarush.island.khmelov.entity.organizms.Organism;

@Setting(name = "Трава", icon = "\u2F8B", maxWeight = 1, maxCount = 200, maxSpeed = 0, maxFood = 0)
public class Plant extends Organism {
    public Plant(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }

}
