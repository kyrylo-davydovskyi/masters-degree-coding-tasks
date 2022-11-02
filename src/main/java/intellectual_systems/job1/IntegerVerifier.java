package intellectual_systems.job1;

import lombok.extern.slf4j.Slf4j;
import utility.ConverterUtil;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class IntegerVerifier {

    //Count numbers which is not divided on all args.
    public int task9(int from, int to, int... notDividedOn) {
        var counter = 0;

        for (int i = from; i < to; i++) {
            var valid = true;

            for (int k : notDividedOn) {
                if (i % k == 0) {
                    valid = false;
                    break;
                }
            }
            if (valid)
                counter++;
        }

        return counter;
    }

    //Count the numbers in diapason divisible by N and their last digit
    public int task10(int from, int to, int divisible) {
        var counter = 0;
        for (int i = from; i < to; i++) {
            var lastDigit = (i % 10);
            if (lastDigit == 0)
                continue;
            if (i % divisible == 0 && i % lastDigit == 0) {
                log.info("Number {} could be divided on {} and its own last digit {}", i, divisible, lastDigit);
                counter++;
            }
        }
        return counter;
    }

    //A sum of a number and number written in the reverse order, equals to the square of a natural number. Find all such two-digit numbers.
    public List<Integer> task11(int from, int to) {
        var result = new ArrayList<Integer>();

        for (int i = from; i < to; i++) {
            var reverseNumber = Integer.parseInt(StringReverser.reverse(String.valueOf(i)));
            var sum = i + reverseNumber;

            var sqrRoot = BigDecimal.valueOf(sum).sqrt(MathContext.DECIMAL32);

            if (sqrRoot.remainder(BigDecimal.ONE).equals(BigDecimal.ZERO)) {
                log.info("{} + {} = {}. {} is square of {}", i, reverseNumber, sum, sum, sqrRoot);
                result.add(i);
            }
        }
        return result;
    }


    //Count numbers where double sum of numbers equal to multiplication of numbers;
    public int task12(int from, int to) {
        var counter = 0;

        for (int i = from; i < to; i++) {
            var number = String.valueOf(i);
            var doubleSumOfNumbers = number.chars().map(ConverterUtil::charToInt).sum() * 2;
            var multiply = number.chars().map(ConverterUtil::charToInt).reduce(1, (a, b) -> a * b);

            if (doubleSumOfNumbers == multiply) {
                log.info("Number: {}, Double sum of numbers: {}, Multiply of numbers: {}", number, doubleSumOfNumbers, multiply);
                counter++;
            }
        }

        return counter;
    }
}
