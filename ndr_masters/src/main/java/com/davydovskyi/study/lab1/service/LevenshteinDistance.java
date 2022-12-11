package com.davydovskyi.study.lab1.service;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;


@Slf4j
public class LevenshteinDistance {

    private static final int deletionPrice = 1;
    private static final int insertionPrice = 1;

    public static int calculate(String x, String y) {
        var matrix = calculateMatrix(x, y);
        return matrix[x.length()][y.length()];
    }

    public static int[][] calculateMatrix(String x, String y) {
        var n = x.length() + 1;
        var m = y.length() + 1;
        var result = new int[n][m];

        //Fill first line and first column with values
        IntStream.rangeClosed(0, n - 1).forEach(i -> result[i][0] = i);
        IntStream.rangeClosed(0, m - 1).forEach(i -> result[0][i] = i);


        for (var i = 1; i < n; i++) {
            for (var j = 1; j < m; j++) {
                var substitutionPrice = x.charAt(i - 1) == y.charAt(j - 1) ? 0 : 1;


                var substitutionCost = result[i - 1][j - 1] + substitutionPrice;
                var deletionCost = result[i - 1][j] + deletionPrice;
                var insertionCost = result[i][j - 1] + insertionPrice;
                result[i][j] = min(substitutionCost, deletionCost, insertionCost);
            }
        }
//        Arrays.stream(result).forEach(r -> log.info(Arrays.toString(r)));
        return result;
    }

    private static int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
