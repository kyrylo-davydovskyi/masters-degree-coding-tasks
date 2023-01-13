package com.davydovskyi.study.lab2.service;

import com.davydovskyi.study.lab2.calculator.CanCalculate;
import com.davydovskyi.study.lab2.dto.StatisticDeathItem;
import lombok.SneakyThrows;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbstractController {

    protected static final BigDecimal maxAge = BigDecimal.valueOf(100);

    @SneakyThrows
    protected static List<StatisticDeathItem> process(CanCalculate calculator,
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