package com.davydovskyi.study.lab1.calculator;

import java.time.format.DateTimeFormatter;

public class IntellectualRhythmsCalculator extends BioRhythmsAbstractCalculator {
    public static final int INTELLECTUAL_LENGTH = 32;

    public IntellectualRhythmsCalculator(DateTimeFormatter formatter) {
        super(formatter, INTELLECTUAL_LENGTH);
    }

    public IntellectualRhythmsCalculator() {
        super(INTELLECTUAL_LENGTH);
    }
}
