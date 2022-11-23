package com.davydovskyi.study.utility;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

@Slf4j
public class ConsoleUtil {

    @SneakyThrows
    public static Double readDoubleFromConsole(String description) {
        var scanner = new Scanner(System.in);
        log.info(description);
        return scanner.nextDouble();
    }

    @SneakyThrows
    public static Integer readIntFromConsole(String description) {
        var scanner = new Scanner(System.in);
        log.info(description);
        return scanner.nextInt();
    }

    @SneakyThrows
    public static String readFromConsole(String description) {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        log.info(description);
        return reader.readLine();
    }
}
