package ru.javarush.island.nikolaev.entity.organizms;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Limit {
    private final double maxWeight;
    private final int maxCount;
    private final int maxSpeed;
    private final double maxFood;
}
