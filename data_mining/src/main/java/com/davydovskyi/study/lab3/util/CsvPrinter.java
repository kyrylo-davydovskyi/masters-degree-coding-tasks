package com.davydovskyi.study.lab3.util;

import com.davydovskyi.study.lab3.dto.StatisticItem;
import lombok.SneakyThrows;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvPrinter {

    private static final String[] HEADERS = {
            "Year", "Capital", "Number of clients", "Number of Payout", "Income Payments Sum", "Outcome Payment Sum"
    };

    @SneakyThrows
    public static void createCsvReport(String fileName, List<StatisticItem> data) {
        FileWriter out = new FileWriter(fileName + ".csv");

        try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT
                .withHeader(HEADERS))) {
            data.forEach((x) -> {
                try {
                    printer.printRecord(x.getYear(), x.getCapital().toPlainString(),
                            x.getAliveClients(), x.getDiedClients(),
                            x.getIncomePayments().toPlainString(), x.getOutcomePayments().toPlainString());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}
