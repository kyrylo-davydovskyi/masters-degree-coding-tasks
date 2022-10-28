package intellectual_systems.job1;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SquareRecursiveCalculator {


    //Calculate sqrRoot(2 + sqrRoot(2 + N times)
    public static double calculate(int n) {
        if (n == 0) {
            log.info("Returning sqrt(2) = {}", Math.sqrt(2));
            return Math.sqrt(2);
        }
        var deeper = calculate(n - 1);
        var result = Math.sqrt(2 + deeper);
        log.info("Iteration #{}. sqrt(2 + {}) = {}",n, deeper, result);
        return result;
    }
}
