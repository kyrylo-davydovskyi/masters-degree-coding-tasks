package com.davydovskyi.study.lab2.service;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;

@Slf4j
public class LevenshteinDinstanseAnalyzer {


    public static void printChanges(int[][] matrix, String x, String y) {
        log.info("To convert {} to {} we need to make such changes:", x, y);
        var i = x.length();
        var j = y.length();
        var changes = new ArrayList<String>();
        do {
            var replace = matrix[i - 1][j - 1];
            var delete = matrix[i - 1][j];
            var insert = matrix[i][j - 1];

            if (min(replace, delete, insert) == replace) {
                if (x.charAt(i - 1) != y.charAt(j - 1))
                    changes.add(String.format("Replace %s with %s", x.charAt(i - 1), y.charAt(j - 1)));
                i--;
                j--;
                continue;
            }

            if (min(replace, delete, insert) == insert) {
                changes.add(String.format("Insert %s on position %s", y.charAt(j - 1), j));
                j--;
            }

            if (min(replace, delete, insert) == delete) {
                changes.add(String.format("Delete %s on position %s", x.charAt(i - 1), i));
                i--;
            }

        }
        while (i != 1 && j != 1);

        Collections.reverse(changes);
        changes.forEach(log::info);
    }

    private static int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
