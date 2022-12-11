package com.davydovskyi.study.lab2;

import com.davydovskyi.study.lab1.service.LevenshteinDistance;
import com.davydovskyi.study.lab2.service.LevenshteinDinstanseAnalyzer;
import com.davydovskyi.study.utility.ConsoleUtil;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class LevenshteinDistanceProgram {


    public static void main(String... args) {
        var a = ConsoleUtil.readFromConsole("Input first word");
        var b = ConsoleUtil.readFromConsole("Input second word");

        var matrix = LevenshteinDistance.calculateMatrix(a, b);
        log.info("To convert {} to {} we need to make such changes:", a, b);
        LevenshteinDinstanseAnalyzer.printChanges(matrix, a, b);
    }
}
