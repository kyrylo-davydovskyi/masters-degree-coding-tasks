package data_mining;

import data_mining.calculator.BioRhythmsAbstractCalculator;
import data_mining.calculator.EmotionalRhythmsCalculator;
import data_mining.calculator.IntellectualRhythmsCalculator;
import data_mining.calculator.PhysicalRhythmsCalculator;
import data_mining.dao.User;
import data_mining.services.CoupleService;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class BioRhytmsCalculatorTests {


    public static Stream<Arguments> dataArgs() {
        return Stream.of(
                Arguments.of("01/07/1993", "27/08/2022", new PhysicalRhythmsCalculator(), 0.2817325568),
                Arguments.of("01/07/1993", "18/09/2022",  new PhysicalRhythmsCalculator(), 0.2817325568416),
                Arguments.of("01/07/1993", "27/08/2022", new EmotionalRhythmsCalculator(), 0.5495089781),
                Arguments.of("01/07/1993", "15/08/2022", new EmotionalRhythmsCalculator(), -0.23061587074255224),
                Arguments.of("01/07/1993", "27/08/2022", new IntellectualRhythmsCalculator(), -0.9807852804),
                Arguments.of("01/07/1993", "15/08/2022", new IntellectualRhythmsCalculator(), 0.555570233019)

        );
    }

    @ParameterizedTest
    @MethodSource("dataArgs")
    public void unitTests(String dateOfBirth,
                      String dateToCalculate,
                      BioRhythmsAbstractCalculator calculator,
                      double expected) {

        var result = calculator.calculate(dateOfBirth, dateToCalculate);

        log.info("User with dateOfBirth[{}] at the date[{}] would have such score[{}] using calculator[{}]", dateOfBirth, dateToCalculate, result, calculator.getClass());

        assertThat(result)
                .isCloseTo(expected, Offset.offset(0.003));
    }

    @Test
    @Disabled
    public void demonstratePhysical() {
        var usr1 = new User("Kyrylo", "01/01/1997");
        var usr2 = new User("Alla", "06/06/1998");

        var dateRangeStart = "02/11/2022";
        var dateRangeEnd = "16/11/2022";

        CoupleService.processCouple(usr1, usr2, "PHYSICAL", dateRangeStart, dateRangeEnd, new PhysicalRhythmsCalculator());
        CoupleService.processCouple(usr1, usr2, "EMOTIONAL", dateRangeStart, dateRangeEnd, new EmotionalRhythmsCalculator());
        CoupleService.processCouple(usr1, usr2, "INTELLECTUAL", dateRangeStart, dateRangeEnd, new IntellectualRhythmsCalculator());

    }
}
