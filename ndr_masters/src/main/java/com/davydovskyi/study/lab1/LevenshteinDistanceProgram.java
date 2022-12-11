package com.davydovskyi.study.lab1;

import com.davydovskyi.study.lab1.service.LevenshteinDistance;
import com.davydovskyi.study.utility.ConsoleUtil;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class LevenshteinDistanceProgram {


    public static void main(String... args) {
        var a = ConsoleUtil.readFromConsole("Input first word");
        var b = ConsoleUtil.readFromConsole("Input second word");

        var distance = LevenshteinDistance.calculate(a, b);
        log.info("Distance between {} and {} equals to {}", a, b, distance);
    }
}
