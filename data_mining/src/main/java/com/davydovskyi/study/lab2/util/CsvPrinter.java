package com.davydovskyi.study.lab2.util;

import com.davydovskyi.study.lab2.dto.StatisticDeathItem;
import lombok.SneakyThrows;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvPrinter {

    private static final String[] HEADERS = {"year", "coefficient",
            "alive count", "alive percent",
            "dead count", "dead percent",
            "died during iteration",
            "chance to survive", "chance to die",
            "Dx", "Cx", "Nx", "Mx",
    };

    @SneakyThrows
    public static void createCsvReport(String fileName, List<StatisticDeathItem> data)  {
        FileWriter out = new FileWriter(fileName + ".csv");
        try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT
                .withHeader(HEADERS))) {
            data.forEach((x) -> {
                try {
                    printer.printRecord(x.getYear(), x.getCoefficient(),
                            x.getAliveCount(), x.getAlivePercentTotal(),
                            x.getDeadCount(), x.getDeadPercentTotal(),
                            x.getDiedDuringIteration(),
                            x.getChanceToSurvive(), x.getChanceToSurvive(),
                            x.getDx(), x.getCx(), x.getNx(), x.getMx());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}
