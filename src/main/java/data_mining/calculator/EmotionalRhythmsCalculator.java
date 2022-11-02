package data_mining.calculator;

import lombok.extern.slf4j.Slf4j;

import java.time.format.DateTimeFormatter;

@Slf4j
public class EmotionalRhythmsCalculator extends BioRhythmsAbstractCalculator {
    public static final int EMOTIONAL_LENGTH = 27;

    public EmotionalRhythmsCalculator(DateTimeFormatter formatter) {
        super(formatter, EMOTIONAL_LENGTH);
    }

    public EmotionalRhythmsCalculator() {
        super( EMOTIONAL_LENGTH);
    }
}
