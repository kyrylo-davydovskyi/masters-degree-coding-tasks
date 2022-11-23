package com.davydovskyi.study.lab2;

import com.davydovskyi.study.lab2.service.DemucronService;
import com.davydovskyi.study.lab2.util.FileUtility;
import lombok.extern.slf4j.Slf4j;

import static com.davydovskyi.study.utility.ConsoleUtil.readFromConsole;

@Slf4j
public class Application {

    private static final int[][] demoValues = {
        //   1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7
           { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
           { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
           { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
           { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
           { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
           { 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
           { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
           { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
           { 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
           { 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
           { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0 },
           { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
           { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
           { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
           { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
           { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 }
    };

    public static void main(String... args) {
        do {
            var action = readFromConsole("Select workflow: 1 - Data from file 2 - Demo, 3 - Exit");
            switch (action) {
                case "1":
                    var fileName = readFromConsole("Input fileName: ");
                    var userData = FileUtility.readDataFromFile(fileName);
                    performDemucron(userData);
                    break;
                case "2":
                    performDemucron(demoValues);
                    break;
                case "3":
                    System.exit(0);
            }
        } while (true);
    }

    private static void performDemucron(int[][] values){
        var result = DemucronService.sortGraph(values.length, values);
        result.forEach((key, value) -> log.info("Level: {}, Values {}", key, value));
    }
}
