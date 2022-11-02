package data_mining.calculator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public abstract class BioRhythmsAbstractCalculator {

    private final DateTimeFormatter formatter;
    private final int divider;

    protected BioRhythmsAbstractCalculator(DateTimeFormatter formatter,
                                           int divider) {
        this.formatter = formatter;
        this.divider = divider;
    }

    protected BioRhythmsAbstractCalculator(int divider) {
        this.formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.divider = divider;
    }

    public double calculate(String dateOfBirth, String dateToCalculate) {
        var x = getDaysUntilToday(dateOfBirth, dateToCalculate);
        return Math.sin(
                (2 * x * Math.PI) / divider
        );
    }

    public Map<String, Double> calculate(String dateOfBirth, String dateToCalculateFrom, String dateToCalculateTo) {
        var result = new HashMap<String, Double>();

        var startDate = LocalDate.parse(dateToCalculateFrom, formatter);
        var endDate = LocalDate.parse(dateToCalculateTo, formatter);

        for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1)) {
            var x = getDaysUntilToday(dateOfBirth, date.format(formatter));
            result.put(
                    date.format(formatter),
                    Math.sin(
                            (2 * x * Math.PI) / divider
                    ));
        }
        return result;

    }


    private long getDaysUntilToday(String dateOfBirth, String dateToCalculate) {
        var from = LocalDate.parse(dateOfBirth, formatter);
        var to = LocalDate.parse(dateToCalculate, formatter);

        return ChronoUnit.DAYS.between(from, to);
    }
}
