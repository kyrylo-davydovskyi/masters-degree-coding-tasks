package intellectual_systems.job1;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


@Slf4j
public class LuckyTicketTests {

    public static Stream<Arguments> testPositiveArguments() {
        return Stream.of(
                Arguments.of("000000"),
                Arguments.of("020011"),
                Arguments.of("010001"),
                Arguments.of("21000012")
        );
    }

    @ParameterizedTest
    @MethodSource("testPositiveArguments")
    public void testValidationFuncPositiveTest(String number) {
        var executor = new LuckyTicketCalculator();
        assertThat(executor.testNumber(number))
                .isTrue();
    }

    public static Stream<Arguments> testNegativeArguments() {
        return Stream.of(
                Arguments.of("010000"),
                Arguments.of("030011"),
                Arguments.of("040001"),
                Arguments.of("21000015")
        );
    }

    @ParameterizedTest
    @MethodSource("testNegativeArguments")
    public void testValidationFuncNegativeTest(String number) {
        var executor = new LuckyTicketCalculator();
        assertThat(executor.testNumber(number))
                .isFalse();
    }

    @Test
    @Tag("Demonstration")
    public void demonstrateTask7() {
        log.info("Task #7");
        var executor = new LuckyTicketCalculator();
        var result = executor.getNumberOfTickets(6, false);
        log.info("Total number of tickets: {}", result);
    }
}
