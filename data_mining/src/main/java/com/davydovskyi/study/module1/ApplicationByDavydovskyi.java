package com.davydovskyi.study.module1;

import com.davydovskyi.study.lab2.service.GompertzController;
import com.davydovskyi.study.lab2.service.MoivreController;
import com.davydovskyi.study.module1.calculator.GompertzCalculator;
import com.davydovskyi.study.module1.util.CsvReader;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.Map;

import static com.davydovskyi.study.utility.ConsoleUtil.*;

@Slf4j
public class ApplicationByDavydovskyi {


    @SneakyThrows
    public static void main(String... args) {
        var path = readFromConsole("Input file path: ");
        var expected = CsvReader.read(path);
        var maxAge = expected.keySet().stream().max(Integer::compareTo).orElse(0);

        double a = 0., b = 0., minDelta = 10000.;

        for (double aParam = 0.039; aParam < 0.04; aParam += 0.00001) {
            for (double bParam = 0.005; bParam < 0.007; bParam += 0.0001) {
                var calculator = new GompertzCalculator(BigDecimal.valueOf(aParam), BigDecimal.valueOf(bParam), BigDecimal.valueOf(maxAge));
                var actual = calculator.calculate();
                var delta = calculateDelta(expected, actual);
                if (delta < minDelta) {
                    log.info("delta = {}, a = {}, b = {}", delta, a, b);
                    a = aParam;
                    b = bParam;
                    minDelta = delta;
                }
            }
        }

        log.info("With this parameters delta would equal {}", minDelta);
        log.info("a = {}, b = {}", a, b);
    }

    private static Double calculateDelta(Map<Integer, Double> expected,
                                         Map<Integer, Double> actual) {
        var delta = 0.;

        for (Map.Entry<Integer, Double> line : expected.entrySet()) {
            delta += Math.abs(actual.get(line.getKey()) - line.getValue());
        }
        return delta;
    }
}
