package intellectual_systems.job1;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


@Slf4j
public class IntegerVerifierTest {

    private final IntegerVerifier executor = new IntegerVerifier();


    @Test
    @Disabled
    public void demonstrateTask9() {
        log.info("Task #9");
        var result = executor.task9(0, 9999, 5, 7);
        log.info("Result: {}", result);
    }

    @Test
    @Disabled
    public void demonstrateTask10() {
        log.info("Task #10");
        var result = executor.task10(0, 9999, 23);
        log.info("Result: {}", result);
    }

    @Test
    @Disabled
    public void demonstrateTask11() {
        log.info("Task #11");
        var result = executor.task11(10, 99);
        log.info("Result: {}", result);
    }

    @Test
    @Disabled
    public void demonstrateTask12() {
        log.info("Task #12");
        var result = executor.task12(10, 99);
        log.info("Result: {}", result);
    }
}
