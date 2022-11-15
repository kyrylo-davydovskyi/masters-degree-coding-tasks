package com.davydovskyi.study.lab1.util;

import lombok.SneakyThrows;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

public class CsvPrinter {

    private static final String[] MultiUserHeaders = {"Date", "User 1 score", "User 2 score"};
    private static final String[] SinglUserHeaders = {"Date", "User score"};



    @SneakyThrows
    public static void createCsvReport(String fileName,
                                       Map<LocalDate, Double> user)  {
        FileWriter out = new FileWriter(fileName + ".csv");
        try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT
                .withHeader(SinglUserHeaders))) {

            user.forEach((key, value) -> {
                try {
                    printer.printRecord(key,
                            value);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    @SneakyThrows
    public static void createCsvReport(String fileName,
                                       Map<LocalDate, Double> user1,
                                       Map<LocalDate, Double> user2)  {
        FileWriter out = new FileWriter(fileName + ".csv");
        try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT
                .withHeader(MultiUserHeaders))) {

            user1.forEach((key, value) -> {
                try {
                    printer.printRecord(key,
                            value,
                            user2.get(key));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}
