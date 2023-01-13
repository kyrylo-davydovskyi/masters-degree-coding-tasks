package com.davydovskyi.study.lab2.service;

import com.davydovskyi.study.lab2.calculator.GompertzCalculator;
import com.davydovskyi.study.lab2.util.CsvPrinter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.Map;


@Slf4j
public class GompertzController extends AbstractController {

    @SneakyThrows
    public static void calculate(Double a, Double b, Integer totalPopulation, Double percentCoef) {
        log.info("Performing calculations with args a[{}], b[{}], norm percent[{}], totalPopulation[{}], maxAge[{}]", a, b, percentCoef, totalPopulation, maxAge);

        var result = process(new GompertzCalculator(BigDecimal.valueOf(a), BigDecimal.valueOf(b), maxAge),
                totalPopulation,
                percentCoef);

        var fileName = String.format("Gompertz_%s_%s_%s_%s", totalPopulation, a, b, percentCoef);
        log.info("Writing information to {}", fileName);
        CsvPrinter.createCsvReport(fileName, result);
    }

    public static void dredgeData(Map<Integer, Double> expectedData) {

    }
}
