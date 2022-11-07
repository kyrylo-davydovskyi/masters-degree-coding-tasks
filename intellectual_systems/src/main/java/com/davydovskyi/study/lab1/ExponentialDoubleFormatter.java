package com.davydovskyi.study.lab1;

import java.text.DecimalFormat;

public class ExponentialDoubleFormatter {

    private static final DecimalFormat formatter = new DecimalFormat("0.0E0");

    public static String format(double number) {
        return formatter.format(number)
                .replace(",", ".");
    }
}
