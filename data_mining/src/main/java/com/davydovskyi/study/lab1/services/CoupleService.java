package com.davydovskyi.study.lab1.services;

import com.davydovskyi.study.lab1.calculator.BioRhythmsAbstractCalculator;
import com.davydovskyi.study.lab1.dao.User;
import com.davydovskyi.study.lab1.util.CsvPrinter;
import com.davydovskyi.study.utility.MapUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CoupleService {

    public static void processCouple(User user1,
                                     User user2,
                                     String dateRangeStart,
                                     String dateRangeEnd,
                                     BioRhythmsAbstractCalculator calculator) {
        log.info("Analyzing {} status", calculator.getName());
        var map1 = UserService.analyze(user1, dateRangeStart, dateRangeEnd, calculator, false);
        var map2 = UserService.analyze(user2, dateRangeStart, dateRangeEnd, calculator, false);

        var mergedData = MapUtils.mergeMaps(map1, map2);


        log.info("Worst day for a couple in {} aspect: {}", calculator.getName(), MapUtils.foundByMinValue(mergedData));
        log.info("Best day for a couple in {} aspect: {}", calculator.getName(), MapUtils.foundByMaxValue(mergedData));

        var fileName = calculator.getName() + "_" + user1.getName() + "+" + user2.getName();
        log.info("Table with calculations and chart in CSV report {}", fileName);
        CsvPrinter.createCsvReport(fileName, map1, map2);
    }
}
