package com.davydovskyi.study;

import com.davydovskyi.study.lab1.calculator.BioRhythmsAbstractCalculator;
import com.davydovskyi.study.lab1.calculator.EmotionalRhythmsCalculator;
import com.davydovskyi.study.lab1.calculator.IntellectualRhythmsCalculator;
import com.davydovskyi.study.lab1.calculator.PhysicalRhythmsCalculator;
import com.davydovskyi.study.lab1.dao.User;
import com.davydovskyi.study.lab1.services.CoupleService;
import com.davydovskyi.study.lab1.services.UserService;
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
public class BioRhythmsCalculatorTests {


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
    @Disabled
    public void unitTests(String dateOfBirth,
                      String dateToCalculate,
                      BioRhythmsAbstractCalculator calculator,
                      double expected) {

        var result = calculator.calculate(dateOfBirth, dateToCalculate);

        log.info("User with dateOfBirth[{}] at the date[{}] would have such score[{}] using calculator[{}]", dateOfBirth, dateToCalculate, result, calculator.getClass());

        assertThat(result)
                .isCloseTo(expected, Offset.offset(0.003));
    }

    public static Stream<Arguments> prognosesForUser() {
        var user = new User("Kyrylo", "01/01/1998");
        var dateFrom = "07/11/2022";
        var dateTo = "07/12/2022";

        return Stream.of(
                Arguments.of("Physical", user, dateFrom, dateTo, new PhysicalRhythmsCalculator()),
                Arguments.of("Emotional", user, dateFrom, dateTo, new EmotionalRhythmsCalculator()),
                Arguments.of("Intellectual", user, dateFrom, dateTo, new IntellectualRhythmsCalculator())

        );
    }

    @ParameterizedTest
    @MethodSource("prognosesForUser")
    @Disabled
    public void demonstrateSingleMeasure(String calculatorName, User user, String dateFrom, String dateTo, BioRhythmsAbstractCalculator calculator) {
        UserService.analyze(user, calculatorName, dateFrom, dateTo, calculator);
    }

    @Test
    @Disabled
    public void demonstrateCouple() {
        var usr1 = new User("Kyrylo", "01/01/1998");
        var usr2 = new User("Usr2", "01/01/1999");

        var dateRangeStart = "07/11/2022";
        var dateRangeEnd = "07/12/2022";

        CoupleService.processCouple(usr1, usr2, "PHYSICAL", dateRangeStart, dateRangeEnd, new PhysicalRhythmsCalculator());
        CoupleService.processCouple(usr1, usr2, "EMOTIONAL", dateRangeStart, dateRangeEnd, new EmotionalRhythmsCalculator());
        CoupleService.processCouple(usr1, usr2, "INTELLECTUAL", dateRangeStart, dateRangeEnd, new IntellectualRhythmsCalculator());

    }
}
