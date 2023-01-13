package com.davydovskyi.study.module1.calculator;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

@AllArgsConstructor
public class GompertzCalculator implements CanCalculate {
    private BigDecimal a;
    private BigDecimal b;
    private BigDecimal maxRange;

    @Override
    public Map<Integer, Double> calculate() {
        var resultMap = new HashMap<Integer, Double>();

        IntStream.rangeClosed(1, maxRange.intValue())
                .forEach(x -> resultMap.put(x, performCalculation(x)));
        return resultMap;
    }


    private Double performCalculation(Integer age) {
        var ageBD = BigDecimal.valueOf(age);
        var upperE = BigDecimal.valueOf(Math.exp((a.multiply(ageBD)).doubleValue()))
                .subtract(BigDecimal.ONE);
        return Math.exp
                (
                        (b.negate().multiply(upperE))
                                .divide(a, 8, RoundingMode.DOWN).doubleValue()
                );
    }
}
