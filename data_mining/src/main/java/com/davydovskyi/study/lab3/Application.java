package com.davydovskyi.study.lab3;

import com.davydovskyi.study.lab3.dto.StatisticItem;
import com.davydovskyi.study.lab3.util.CsvPrinter;
import com.davydovskyi.study.lab3.util.CsvReader;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.ArrayList;

import static com.davydovskyi.study.utility.ConsoleUtil.*;

@Slf4j
public class Application {

    @SneakyThrows
    public static void main(String... args) {
        var path = readFromConsole("Input file path: ");
        var gompertzData = CsvReader.read(path);
        var paymentIncomeAmount = readDoubleFromConsole("Input amount of income payments: ");
        var paymentOutcomeAmount = readDoubleFromConsole("Input amount of outcome payments: ");
        var interestRate = readDoubleFromConsole("Interest Rate: ");

        var maxYear = gompertzData.keySet().stream().max(Integer::compareTo).orElse(0);
        var prevYear = calculateFirstYear(paymentIncomeAmount, paymentOutcomeAmount, gompertzData.get(0));

        var result = new ArrayList<StatisticItem>();
        result.add(prevYear);
        for (int i = 1; i <= maxYear; i++) {
            var clientsAlive = prevYear.getAliveClients() - prevYear.getDiedClients();
            var clientsDied = gompertzData.get(i);
            var capital = (prevYear.getCapital().multiply(BigDecimal.valueOf(1 + interestRate)))
                    .subtract(prevYear.getOutcomePayments())
                    .add(prevYear.getIncomePayments());
            var income = BigDecimal.valueOf(clientsAlive).multiply(BigDecimal.valueOf(paymentIncomeAmount));
            var outcome = BigDecimal.valueOf(clientsDied).multiply(BigDecimal.valueOf(paymentOutcomeAmount));

            prevYear = StatisticItem.builder()
                    .year(i)
                    .capital(capital)
                    .aliveClients(clientsAlive)
                    .diedClients(clientsDied)
                    .incomePayments(income)
                    .outcomePayments(outcome)
                    .build();
            result.add(prevYear);
        }

        CsvPrinter.createCsvReport("result", result);

    }

    private static StatisticItem calculateFirstYear(double paymentIncomeAmount,
                                                    double paymentOutcomeAmount,
                                                    int diedAtFirstYear) {
        var startCapital = readDoubleFromConsole("Input Starting Capital: ");
        var numberOfClients = readIntFromConsole("Input N of clients: ");

        var income = BigDecimal.valueOf(numberOfClients).multiply(BigDecimal.valueOf(paymentIncomeAmount));
        var outcome = BigDecimal.valueOf(diedAtFirstYear).multiply(BigDecimal.valueOf(paymentOutcomeAmount));
        return StatisticItem.builder()
                .year(0)
                .capital(BigDecimal.valueOf(startCapital))
                .aliveClients(numberOfClients)
                .diedClients(diedAtFirstYear)
                .incomePayments(income)
                .outcomePayments(outcome)
                .build();
    }

}
