package com.javarush.island.khmelov.entity.organizms;

import com.javarush.island.khmelov.entity.organizms.animals.predators.Wolf;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OrganismCloneTest {

    @Test
    void differentIdAfterClone(){
        Limit limit = new Limit(1, 2, 3, 4);
        Wolf wolf = new Wolf("v", "i", limit);
        Wolf clone = Organism.clone(wolf);
        Assertions.assertNotEquals(wolf.getId(),clone.getId());
        Assertions.assertNotEquals(wolf,clone);
    }

}