package data_mining.services;

import data_mining.calculator.BioRhythmsAbstractCalculator;
import data_mining.dao.User;
import lombok.extern.slf4j.Slf4j;
import utility.MapUtils;

import java.util.Map;

@Slf4j
public class UserService {

    public Map<String, Double> analyze(User user,
                                       String measureName,
                                       String dateRangeStart,
                                       String dateRangeEnd,
                                       BioRhythmsAbstractCalculator calculator) {
        log.info("Performing {} analyze of user with name={} and dateOfBirth={}", measureName, user.getName(), user.getDateOfBirth());
        log.info("Analyzing daterange from={}, to={}", dateRangeStart, dateRangeEnd);

        var result = calculator.calculate(user.getDateOfBirth(), dateRangeStart, dateRangeEnd);
        log.info("Chart for {}: \n {}", user.getName(), result);

        log.info("Worst day for {}: {}", user.getName(), MapUtils.foundByMinValue(result));

        log.info("Best day for {}: {}", user.getName(), MapUtils.foundByMaxValue(result));
        return result;
    }
}
