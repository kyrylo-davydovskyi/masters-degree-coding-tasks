package com.davydovskyi.study.lab2.service;


import com.davydovskyi.study.lab2.calculator.DeathCalculator;
import com.davydovskyi.study.lab2.calculator.GompertzDeathCalculator;
import com.davydovskyi.study.lab2.calculator.MoivreDeathCalculator;
import com.davydovskyi.study.lab2.dto.StatisticDeathItem;
import com.davydovskyi.study.lab2.util.CsvPrinter;
import lombok.RequiredArgsConstructor;
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
    public static List<StatisticDeathItem> calculateGompertz(Double a, Double b, Integer totalPopulation, Double percentCoef) {
        return process(new GompertzDeathCalculator(BigDecimal.valueOf(a), BigDecimal.valueOf(b), maxAge),
                "GomperzDeath calc by Davydovskyi",
                totalPopulation,
                percentCoef);
    }

    @SneakyThrows
    public static List<StatisticDeathItem> calculateMoivre(Integer totalPopulation, Double percentCoef) {
        return process(new MoivreDeathCalculator(maxAge),
                "Moivre calc by Davydovskyi",
                totalPopulation,
                percentCoef);
    }

    @SneakyThrows
    private static List<StatisticDeathItem> process(DeathCalculator calculator,
                                String chartName,
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
