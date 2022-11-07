package com.davydovskyi.study.lab1.calculator;

import java.time.format.DateTimeFormatter;

public class EmotionalRhythmsCalculator extends BioRhythmsAbstractCalculator {
    public static final int EMOTIONAL_LENGTH = 27;

    public EmotionalRhythmsCalculator(DateTimeFormatter formatter) {
        super(formatter, EMOTIONAL_LENGTH);
    }

    public EmotionalRhythmsCalculator() {
        super( EMOTIONAL_LENGTH);
    }
}
