package ndr_masters;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Slf4j
public class CombinationsTest {


    public static Stream<Arguments> task1ArgumentSource() {
        return Stream.of(
                Arguments.of(10, 5, 2, 2)
        );
    }


    @ParameterizedTest
    @MethodSource("task1ArgumentSource")
    @Tag("Demonstration")
    public void task1(int totalBoys,
                      int totalGirls,
                      int requiredBoys,
                      int requiredGirls) {
        var boys = CombinationCalculator.getCombinationWithoutRepeats(totalBoys, requiredBoys);
        var girls = CombinationCalculator.getCombinationWithoutRepeats(totalGirls, requiredGirls);

        log.info("Boys. Total[{}], Required[{}], Combinations[{}]", totalBoys, requiredBoys, boys);
        log.info("Girls. Total[{}], Required[{}], Combinations[{}]", totalGirls, requiredGirls, girls);
        log.info("Total number of sets: {} * {} = {}", boys, girls, boys * girls);
    }

    public static Stream<Arguments> task2ArgumentSource() {
        return Stream.of(
                Arguments.of(5, 8)
        );
    }


    @ParameterizedTest
    @MethodSource("task2ArgumentSource")
    @Tag("Demonstration")
    public void task2(int uniqueOptions,
                      int requiredNumber) {
        var result = CombinationCalculator.getCombinationWithRepeats(uniqueOptions, requiredNumber);

        log.info("Unique Options[{}], Required[{}], Combinations[{}]", uniqueOptions, requiredNumber, result);
    }
}
