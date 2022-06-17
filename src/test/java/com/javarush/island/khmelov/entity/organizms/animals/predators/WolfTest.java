package com.javarush.island.khmelov.entity.organizms.animals.predators;

import com.javarush.island.khmelov.entity.organizms.Limit;
import com.javarush.island.khmelov.entity.organizms.Organism;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WolfTest {

    @Test
    void differentIdAfterClone(){
        Limit limit = new Limit(1, 2, 3, 4);
        Wolf wolf = new Wolf("v", "i", 1, limit);
        Wolf clone = Organism.clone(wolf);
        Assertions.assertNotEquals(wolf.getId(),clone.getId());
        Assertions.assertNotEquals(wolf,clone);
    }

}