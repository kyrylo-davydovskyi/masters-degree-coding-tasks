package ndr_masters;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class StringReverserTests {

    public static Stream<Arguments> testArguments() {
        return Stream.of(
                Arguments.of("abc", "cba"),
                Arguments.of("check", "kcehc"),
                Arguments.of("lol", "lol")
        );
    }

    @ParameterizedTest
    @MethodSource("testArguments")
    @Tag("Demonstration")
    public void demonstrateTask8(String source, String expected) {
        log.info("Task #8");
        var actual = StringReverser.reverse(source);
        log.info("Source string: {}, Actual: {}, Expected: {}", source, actual, expected);
        assertThat(actual).isEqualTo(expected);
    }
}
