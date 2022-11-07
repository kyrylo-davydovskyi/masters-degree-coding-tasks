package com.davydovskyi.study.lab1.services;

import com.davydovskyi.study.lab1.calculator.BioRhythmsAbstractCalculator;
import com.davydovskyi.study.lab1.dao.User;
import com.davydovskyi.study.utility.MapUtils;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.Map;

@Slf4j
public class UserService {

    public static Map<LocalDate, Double> analyze(User user,
                                                 String measureName,
                                                 String dateRangeStart,
                                                 String dateRangeEnd,
                                                 BioRhythmsAbstractCalculator calculator) {
        log.info("Performing {} analyze of user with name={} and dateOfBirth={}", measureName, user.getName(), user.getDateOfBirth());
        log.info("Analyzing date range from={}, to={}", dateRangeStart, dateRangeEnd);

        var result = calculator.calculate(user.getDateOfBirth(), dateRangeStart, dateRangeEnd);
        log.info("Chart for {}:", user.getName());
        result.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(x -> log.info("At day[{}] {} would have {} score - {}", x.getKey(), user.getName(), measureName, x.getValue()));

        log.info("Worst day for {}: {}", user.getName(), MapUtils.foundByMinValue(result));

        log.info("Best day for {}: {}", user.getName(), MapUtils.foundByMaxValue(result));
        return result;
    }
}
