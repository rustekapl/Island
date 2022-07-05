package ru.javarush.island.ryabov.entity.organisms;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Limit {
    private final double maxWeight;
    private final int maxCountInCell;
    private final int maxSpeed;
    private final double maxFood;
    private final String icon;
    private final String name;
}