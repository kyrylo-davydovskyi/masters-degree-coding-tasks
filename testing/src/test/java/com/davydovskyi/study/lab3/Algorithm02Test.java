package com.davydovskyi.study.lab3;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class Algorithm02Test {

    public static Stream<Arguments> argsForFirstCond() {
        return Stream.of(
                Arguments.of(16, 16),
                Arguments.of(17, 17),
                Arguments.of(18, -1) //testing first action
        );
    }

    public static Stream<Arguments> argsForSecondCond() {
        return Stream.of(
                Arguments.of(-13, 0), // testing second action
                Arguments.of(30, 0), // testing second action
                Arguments.of(1, 1)
        );
    }

    public static Stream<Arguments> mergedSourceToImitateFindingBugs() {
        return Stream.concat(
                argsForFirstCond(),
                argsForSecondCond()
        );
    }

    @ParameterizedTest
    @MethodSource("argsForFirstCond")
    public void testFirstIf(int x, double expected) {
        var actual = AlgorithmExecutor.schema2(x);
        assertThat(actual)
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("argsForSecondCond")
    public void testSecondIf(int x, double expected) {
        var actual = AlgorithmExecutor.schema2(x);
        assertThat(actual)
                .isEqualTo(expected);
    }


    @ParameterizedTest
    @MethodSource("mergedSourceToImitateFindingBugs")
    @Disabled
    public void testOnBroken01(int x, double expected) {
        var actual = AlgorithmExecutor.schema2Broken01(x);
        assertThat(actual)
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("mergedSourceToImitateFindingBugs")
    @Disabled
    public void testOnBroken02(int x, double expected) {
        var actual = AlgorithmExecutor.schema2Broken02(x);
        assertThat(actual)
                .isEqualTo(expected);
    }
}
