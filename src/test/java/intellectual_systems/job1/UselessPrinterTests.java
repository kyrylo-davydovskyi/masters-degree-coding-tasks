package intellectual_systems.job1;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


@Slf4j
public class UselessPrinterTests {

    public static Stream<Arguments> testArguments() {
        return Stream.of(
                Arguments.of(5),
                Arguments.of(3),
                Arguments.of(1),
                Arguments.of(9)
        );
    }

    @ParameterizedTest
    @MethodSource("testArguments")
    @Disabled
    public void demostrateTask6(int x) {
        log.info("Task #6");
        var executor = new UselessPrinter();
        executor.task6(x);
    }

    @Test
    public void nLessThan1() {
        var executor = new UselessPrinter();
        assertThatThrownBy(() -> executor.task6(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
