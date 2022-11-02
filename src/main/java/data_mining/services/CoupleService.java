package data_mining.services;

import data_mining.calculator.BioRhythmsAbstractCalculator;
import data_mining.dao.User;
import lombok.extern.slf4j.Slf4j;
import utility.MapUtils;

@Slf4j
public class CoupleService {

    public static void processCouple(User user1,
                                     User user2,
                                     String measureName,
                                     String dateRangeStart,
                                     String dateRangeEnd,
                                     BioRhythmsAbstractCalculator calculator) {
        var userService = new UserService();
        log.info("Analyzing {} status", measureName);
        var map1 = userService.analyze(user1, measureName, dateRangeStart, dateRangeEnd, calculator);
        var map2 = userService.analyze(user2, measureName, dateRangeStart, dateRangeEnd, calculator);


        var mergedData = MapUtils.mergeMaps(map1, map2);

        log.info("Worst day for a couple in {} aspect: {}", measureName, MapUtils.foundByMinValue(mergedData));
        log.info("Best day for a couple in {} aspect: {}", measureName, MapUtils.foundByMinValue(mergedData));
    }
}
