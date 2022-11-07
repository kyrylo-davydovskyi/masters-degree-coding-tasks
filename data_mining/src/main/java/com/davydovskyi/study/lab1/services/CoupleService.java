package com.davydovskyi.study.lab1.services;

import com.davydovskyi.study.lab1.calculator.BioRhythmsAbstractCalculator;
import com.davydovskyi.study.lab1.dao.User;
import com.davydovskyi.study.utility.MapUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CoupleService {

    public static void processCouple(User user1,
                                     User user2,
                                     String measureName,
                                     String dateRangeStart,
                                     String dateRangeEnd,
                                     BioRhythmsAbstractCalculator calculator) {
        log.info("Analyzing {} status", measureName);
        var map1 = UserService.analyze(user1, measureName, dateRangeStart, dateRangeEnd, calculator);
        var map2 = UserService.analyze(user2, measureName, dateRangeStart, dateRangeEnd, calculator);


        var mergedData = MapUtils.mergeMaps(map1, map2);

        log.info("Worst day for a couple in {} aspect: {}", measureName, MapUtils.foundByMinValue(mergedData));
        log.info("Best day for a couple in {} aspect: {}", measureName, MapUtils.foundByMinValue(mergedData));
    }
}
