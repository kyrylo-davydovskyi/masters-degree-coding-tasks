package data_mining.calculator;

import lombok.extern.slf4j.Slf4j;

import java.time.format.DateTimeFormatter;

@Slf4j
public class IntellectualRhythmsCalculator extends BioRhythmsAbstractCalculator {
    public static final int INTELLECTUAL_LENGTH = 32;

    public IntellectualRhythmsCalculator(DateTimeFormatter formatter) {
        super(formatter, INTELLECTUAL_LENGTH);
    }

    public IntellectualRhythmsCalculator() {
        super(INTELLECTUAL_LENGTH);
    }
}
