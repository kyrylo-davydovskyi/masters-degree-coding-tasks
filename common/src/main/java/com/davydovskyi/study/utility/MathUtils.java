package com.davydovskyi.study.utility;

import java.util.stream.IntStream;

public class MathUtils {

    public static int factorial(int n) {
        return IntStream.rangeClosed(1, n)
                .reduce(1, (x, y) -> x * y);
    }
}
