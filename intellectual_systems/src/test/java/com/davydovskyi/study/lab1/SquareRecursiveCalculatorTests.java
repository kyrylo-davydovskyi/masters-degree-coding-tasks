package com.davydovskyi.study.lab1;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class SquareRecursiveCalculatorTests {

    public static Stream<Arguments> testArguments() {
        return Stream.of(
                Arguments.of(2, 1.9615705608064609),
                Arguments.of(1, 1.8477590650225735),
                Arguments.of(0, 1.4142135623730951)
        );
    }

    @ParameterizedTest
    @MethodSource("testArguments")
    public void demonstrateTask4(int x, double expected) {
        log.info("Task #4. Testing value: {}, Expected: {}", x, expected);
        var actual = SquareRecursiveCalculator.calculate(x);
        assertThat(actual).isEqualTo(expected);
    }
}
