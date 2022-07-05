package ru.javarush.island.bityutskih.services;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ServiceLimits {
    private final int maxCountInService;
    private final double maxWeight;
    private final int maxSpeed;
    private final double maxFood;
    private final int flockSize;
}
