package com.davydovskyi.study;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class LevenshteinDistanceTests {

    public static Stream<Arguments> testArguments() {
        return Stream.of(
                Arguments.of("lol", "kek", 3),
                Arguments.of("hyndai", "honda", 2),
                Arguments.of("hoho", "heh", 2),
                Arguments.of("rain", "shine", 3),
                Arguments.of("rainbow1234", "rain", 7),
                Arguments.of("check", "not check", 4)
        );
    }

    @ParameterizedTest
    @MethodSource("testArguments")
    public void levenshteinDistanceTests(String line1,
                                         String line2,
                                         int expected) {
        log.info("Line 1: {}", line1);
        log.info("Line 2: {}", line2);
        log.info("Expected distance: {}", expected);

        var actual = LevenshteinDistance.calculate(line1, line2);

        log.info("Actual: {}", actual);
        assertThat(actual)
                .isEqualTo(expected);
    }
}
