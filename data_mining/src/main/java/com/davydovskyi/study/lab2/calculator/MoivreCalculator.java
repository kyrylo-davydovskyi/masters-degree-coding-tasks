package com.davydovskyi.study.lab2.calculator;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

@AllArgsConstructor
@Slf4j
public class MoivreCalculator implements CanCalculate {

    private BigDecimal maxAge;


    @Override
    public Map<Integer, Double> calculate() {
        log.info("Performing calculations with arg maxAge[{}]", maxAge);
        var resultMap = new HashMap<Integer, Double>();

        IntStream.rangeClosed(1, maxAge.intValue())
                .forEach(x -> resultMap.put(x, performCalculation(x)));
        return resultMap;
    }


    private Double performCalculation(int age) {
        var ageBD = BigDecimal.valueOf(age);
        var coefficient = BigDecimal.ONE.subtract(
                ageBD.divide(maxAge, 8, RoundingMode.DOWN));
        return coefficient.doubleValue();
    }
}
