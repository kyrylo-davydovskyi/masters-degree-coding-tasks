package com.davydovskyi.study.lab1;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class PolynomialCalculatorTests {

    public static Stream<Arguments> testArguments() {
        return Stream.of(
                Arguments.of(3, -26),
                Arguments.of(-2, -22),
                Arguments.of(10, -102),
                Arguments.of(37, -130),
                Arguments.of(7, -50),
                Arguments.of(5, -2)
        );
    }

    @ParameterizedTest
    @MethodSource("testArguments")
    public void demonstrateTask4(int x, int expected) {
        log.info("Task #4");
        var executor = new PolynomialCalculator();
        var actual = executor.calculate(x);
        var template = "2*%s^4 - 7*%s^3 + 3*%s^2 + 2*%s -5".replace("%s", String.valueOf(x));
        log.info("Polynomial: {} = {}. Expected result: {}", template, actual, expected);

        assertThat(actual).isEqualTo(expected);
    }
}
