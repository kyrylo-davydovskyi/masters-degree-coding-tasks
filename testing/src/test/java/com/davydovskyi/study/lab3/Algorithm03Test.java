package com.davydovskyi.study.lab3;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Slf4j
public class Algorithm03Test {

    public static Stream<Arguments> negativeCases() {
        return Stream.of(
                Arguments.of(-1, 50, "N supposed to be in Range(0, 10)"),
                Arguments.of(0, 50, "N supposed to be in Range(0, 10)"),
                Arguments.of(1, -101, "X supposed to be in Range(-100, 100)"),
                Arguments.of(1, 101, "X supposed to be in Range(-100, 100)")
        );
    }

    public static Stream<Arguments> positiveCases() {
        return Stream.of(
                Arguments.of(1, 1, 1),
                Arguments.of(1, 2, 2),
                Arguments.of(3, 2, 8)
        );
    }

    @ParameterizedTest
    @MethodSource("negativeCases")
    public void negativeTest(int n, int x, String exception) {
        assertThatThrownBy(() -> AlgorithmExecutor.schema3(n, x))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(exception);
    }

    @ParameterizedTest
    @MethodSource("positiveCases")
    public void positiveTest(int n, int x, int expected) {
        var actual = AlgorithmExecutor.schema3(n, x);
        assertThat(actual)
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("positiveCases")
    @Disabled
    public void testOnBroken01(int n, int x, int expected) {
        var actual = AlgorithmExecutor.schema3Brpken01(n, x);
        assertThat(actual)
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("positiveCases")
    @Disabled
    public void testOnBroken02(int n, int x, int expected) {
        var actual = AlgorithmExecutor.schema3Brpken02(n, x);
        assertThat(actual)
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("positiveCases")
    @Disabled
    public void testOnBroken03(int n, int x, int expected) {
        var actual = AlgorithmExecutor.schema3Brpken03(n, x);
        assertThat(actual)
                .isEqualTo(expected);
    }
}
