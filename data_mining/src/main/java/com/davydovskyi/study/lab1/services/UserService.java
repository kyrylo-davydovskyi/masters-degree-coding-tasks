package com.davydovskyi.study.lab1.services;

import com.davydovskyi.study.lab1.calculator.BioRhythmsAbstractCalculator;
import com.davydovskyi.study.lab1.dao.User;
import com.davydovskyi.study.lab1.util.CsvPrinter;
import com.davydovskyi.study.utility.MapUtils;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.Map;

@Slf4j
public class UserService {

    public static Map<LocalDate, Double> analyze(User user,
                                                 String dateRangeStart,
                                                 String dateRangeEnd,
                                                 BioRhythmsAbstractCalculator calculator,
                                                 Boolean writeToCsv) {
        log.info("Performing {} analyze of user with name={} and dateOfBirth={}", calculator.getName(), user.getName(), user.getDateOfBirth());
        log.info("Analyzing date range from={}, to={}", dateRangeStart, dateRangeEnd);

        var result = calculator.calculate(user.getDateOfBirth(), dateRangeStart, dateRangeEnd);

        if(writeToCsv) {
            var fileName = calculator.getName() + "_" + user.getName();
            log.info("Writing results to {}.csv", fileName);
            CsvPrinter.createCsvReport(fileName, result);
        }

        log.info("Worst day for {}: {}", user.getName(), MapUtils.foundByMinValue(result));

        log.info("Best day for {}: {}", user.getName(), MapUtils.foundByMaxValue(result));

        return result;
    }
}
