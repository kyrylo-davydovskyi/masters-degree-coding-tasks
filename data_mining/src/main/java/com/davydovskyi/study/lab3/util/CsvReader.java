package com.davydovskyi.study.lab3.util;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class CsvReader {

    private static final String delimiter = ",";


    @SneakyThrows
    public static Map<Integer, Integer> read(String filePath) {
        log.info("Reading data from file {}", filePath);
        var result = new HashMap<Integer, Integer>();
        var scanner = new BufferedReader(new FileReader(filePath));

        scanner.lines()
                .forEach(line -> {
                    var cells = line.split(delimiter);
                    try {
                        result.put(Integer.parseInt(cells[0]), Integer.parseInt(cells[1]));
                    } catch (NumberFormatException exception) {
                        log.warn("Skipping line!! Line is broken!!!");
                    }
                });

        return result;
    }
}
