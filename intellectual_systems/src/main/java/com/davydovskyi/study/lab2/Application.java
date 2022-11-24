package com.davydovskyi.study.lab2;

import com.davydovskyi.study.lab2.service.DemucronService;
import com.davydovskyi.study.lab2.util.FileUtility;
import lombok.extern.slf4j.Slf4j;

import static com.davydovskyi.study.utility.ConsoleUtil.readFromConsole;

@Slf4j
public class Application {

    public static void main(String... args) {
        do {
            var action = readFromConsole("Select action: 1 - Data from file 2 - Exit");
            switch (action) {
                case "1":
                    var fileName = readFromConsole("Input fileName: ");
                    var userData = FileUtility.readDataFromFile(fileName);
                    DemucronService.sortGraph(userData.length, userData)
                            .forEach((key, value) -> log.info("Level: {}, Values {}", key, value));
                    break;
                case "2":
                    System.exit(0);
            }
        } while (true);
    }
}
