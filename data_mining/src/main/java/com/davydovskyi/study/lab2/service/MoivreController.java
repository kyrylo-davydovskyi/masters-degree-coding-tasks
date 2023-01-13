package com.davydovskyi.study.lab2.service;

import com.davydovskyi.study.lab2.calculator.MoivreCalculator;
import com.davydovskyi.study.lab2.util.CsvPrinter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MoivreController extends AbstractController {

    @SneakyThrows
    public static void calculate(Integer totalPopulation, Double percentCoef) {
        log.info("Performing calculations with args norm percent[{}], totalPopulation[{}], maxAge[{}]", percentCoef, totalPopulation, maxAge);
        var result = process(new MoivreCalculator(maxAge),
                totalPopulation,
                percentCoef);
        var fileName = String.format("Moivre_%s_%s", totalPopulation, percentCoef);
        log.info("Writing information to {}", fileName);
        CsvPrinter.createCsvReport(fileName, result);
    }
}
