package com.davydovskyi.study.lab1.calculator;

import java.time.format.DateTimeFormatter;

public class PhysicalRhythmsCalculator extends BioRhythmsAbstractCalculator {
    public static final int PHYSICAL_LENGTH = 22;

    public PhysicalRhythmsCalculator(DateTimeFormatter formatter) {
        super(formatter, PHYSICAL_LENGTH);
    }

    public PhysicalRhythmsCalculator() {
        super(PHYSICAL_LENGTH);
    }
}
