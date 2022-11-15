package com.davydovskyi.study.lab1;

import com.davydovskyi.study.lab1.calculator.BioRhythmsAbstractCalculator;
import com.davydovskyi.study.lab1.calculator.EmotionalRhythmsCalculator;
import com.davydovskyi.study.lab1.calculator.IntellectualRhythmsCalculator;
import com.davydovskyi.study.lab1.calculator.PhysicalRhythmsCalculator;
import com.davydovskyi.study.lab1.dao.User;
import com.davydovskyi.study.lab1.services.CoupleService;
import com.davydovskyi.study.lab1.services.UserService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Slf4j
public class ApplicationByDavydovskyi {


    @SneakyThrows
    public static void main(String... args) {
        BioRhythmsAbstractCalculator calculator;
        User user;
        String dateFrom, dateTo;

        do {
            var action = readFromConsole("Select workflow: 1 - Single User analyze, 2 - Couple analyze, 3 - demo, 4 - exit");
            switch (action) {
                case "1":
                    calculator = selectCalculator();
                    user = readUser();
                    dateFrom = readFromConsole("Input date from(in format dd/MM/yyyy): ");
                    dateTo = readFromConsole("Input date to(in format dd/MM/yyyy): ");
                    UserService.analyze(user, dateFrom, dateTo, calculator, true);
                    break;
                case "2":
                    calculator = selectCalculator();
                    var user1 = readUser();
                    var user2 = readUser();
                    dateFrom = readFromConsole("Input date from(in format dd/MM/yyyy): ");
                    dateTo = readFromConsole("Input date to(in format dd/MM/yyyy): ");
                    CoupleService.processCouple(user1, user2, dateFrom, dateTo, calculator);
                    break;
                case "3":
                    demo();
                    break;
                case "4":
                    System.exit(0);
            }
        } while (true);


    }

    private static void demo() {
        log.info("This is demo mode.");
        var usr1 = new User("User1", "01/01/1998");
        var usr2 = new User("User2", "02/02/1995");
        var dateFrom = "15/11/2022";
        var dateTo = "15/12/2022";


        UserService.analyze(usr1, dateFrom, dateTo, new PhysicalRhythmsCalculator(), true);
        UserService.analyze(usr1, dateFrom, dateTo, new EmotionalRhythmsCalculator(), true);
        UserService.analyze(usr1, dateFrom, dateTo, new IntellectualRhythmsCalculator(), true);


        CoupleService.processCouple(usr1, usr2, dateFrom, dateTo, new PhysicalRhythmsCalculator());
        CoupleService.processCouple(usr1, usr2, dateFrom, dateTo, new EmotionalRhythmsCalculator());
        CoupleService.processCouple(usr1, usr2, dateFrom, dateTo, new IntellectualRhythmsCalculator());
    }

    @SneakyThrows
    private static BioRhythmsAbstractCalculator selectCalculator() {
        BioRhythmsAbstractCalculator calculator = null;

        do {
            var type = readFromConsole("Please, select type of BioRhythms: 1 - Physical, 2 - Emotional, 3 - Intellectual: ");

            switch (type) {
                case "1":
                    calculator = new PhysicalRhythmsCalculator();
                    break;
                case "2":
                    calculator = new EmotionalRhythmsCalculator();
                    break;
                case "3":
                    calculator = new IntellectualRhythmsCalculator();
                    break;
            }
        }
        while (calculator == null);

        return calculator;
    }

    @SneakyThrows
    private static User readUser() {
        log.info("Fill user data");
        var name = readFromConsole("Input name: ");
        var dateOfBirth = readFromConsole("Input Date of Birth(in format dd/MM/yyyy): ");

        return new User(name, dateOfBirth);
    }

    @SneakyThrows
    private static String readFromConsole(String description) {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        log.info(description);
        return reader.readLine();
    }
}
