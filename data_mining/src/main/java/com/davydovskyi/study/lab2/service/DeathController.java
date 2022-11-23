package com.davydovskyi.study.lab2.service;


import com.davydovskyi.study.lab2.calculator.CanCalculate;
import com.davydovskyi.study.lab2.calculator.GompertzCalculator;
import com.davydovskyi.study.lab2.calculator.MoivreCalculator;
import com.davydovskyi.study.lab2.dto.StatisticDeathItem;
import com.davydovskyi.study.lab2.util.ChartDisplayer;
import com.davydovskyi.study.lab2.util.CsvPrinter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class DeathController {

    private static final BigDecimal maxAge = BigDecimal.valueOf(100);

    @SneakyThrows
    public static void calculateGompertz(Double a, Double b, Integer totalPopulation, Double percentCoef) {
        log.info("Performing calculations with args a[{}], b[{}], norm percent[{}], totalPopulation[{}], maxAge[{}]", a, b, percentCoef, totalPopulation, maxAge);

        var result = process(new GompertzCalculator(BigDecimal.valueOf(a), BigDecimal.valueOf(b), maxAge),
                totalPopulation,
                percentCoef);

        var fileName = String.format("Gompertz_%s_%s_%s_%s", totalPopulation, a, b, percentCoef);
        log.info("Writing information to {}", fileName);
        CsvPrinter.createCsvReport(fileName, result);
        ChartDisplayer.display(result, "Gompertz Approach");
    }

    @SneakyThrows
    public static void calculateMoivre(Integer totalPopulation, Double percentCoef) {
        log.info("Performing calculations with args norm percent[{}], totalPopulation[{}], maxAge[{}]", percentCoef, totalPopulation, maxAge);
        var result = process(new MoivreCalculator(maxAge),
                totalPopulation,
                percentCoef);
        var fileName = String.format("Moivre_%s_%s", totalPopulation, percentCoef);
        log.info("Writing information to {}", fileName);
        CsvPrinter.createCsvReport(fileName, result);
        ChartDisplayer.display(result, "Moivre Approach");
    }

    @SneakyThrows
    private static List<StatisticDeathItem> process(CanCalculate calculator,
                                                    Integer totalPopulation,
                                                    Double percentCoef) {
        var coefficients = calculator.calculate();
        var resultList = new ArrayList<StatisticDeathItem>();
        for (Map.Entry<Integer, Double> entry : coefficients.entrySet()) {
            resultList.add(new StatisticDeathItem(entry.getKey(), totalPopulation, entry.getValue(), percentCoef));
        }

        resultList.forEach(x -> {
            var dxList = resultList.stream()
                    .filter(y -> y.getYear() > x.getYear())
                    .map(StatisticDeathItem::getDx)
                    .collect(Collectors.toList());

            var cxList = resultList.stream()
                    .filter(y -> y.getYear() > x.getYear())
                    .map(StatisticDeathItem::getCx)
                    .collect(Collectors.toList());

            var previous = resultList.stream()
                    .filter(y -> x.getYear() - 1 == y.getYear())
                    .findFirst()
                    .map(StatisticDeathItem::getAliveCount)
                    .orElse(totalPopulation);
            x.setChances(previous);
            x.setNx(dxList);
            x.setMx(cxList);
        });

        return resultList;
    }
}
