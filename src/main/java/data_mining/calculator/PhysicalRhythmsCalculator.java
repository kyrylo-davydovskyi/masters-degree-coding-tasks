package data_mining.calculator;

import lombok.extern.slf4j.Slf4j;

import java.time.format.DateTimeFormatter;

@Slf4j
public class PhysicalRhythmsCalculator extends BioRhythmsAbstractCalculator {
    public static final int PHYSICAL_LENGTH = 22;

    public PhysicalRhythmsCalculator(DateTimeFormatter formatter) {
        super(formatter, PHYSICAL_LENGTH);
    }

    public PhysicalRhythmsCalculator() {
        super( PHYSICAL_LENGTH);
    }
}
