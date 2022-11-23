package com.davydovskyi.study.lab2;

import com.davydovskyi.study.lab2.service.DeathController;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import static com.davydovskyi.study.utility.ConsoleUtil.*;

@Slf4j
public class ApplicationByDavydovskyi {


    @SneakyThrows
    public static void main(String... args) {
        Integer totalPeople;
        Double normPercent;

        do {
            var action = readFromConsole("Select workflow: 1 - Gompertz approach, 2 - Moivre approach, 3 - demo, 4 - exit");
            switch (action) {
                case "1":
                    var a = readDoubleFromConsole("Input a param: ");
                    var b = readDoubleFromConsole("Input b param: ");
                    totalPeople = readIntFromConsole("Input Total people: ");
                    normPercent = readDoubleFromConsole("Input norm of percent: ");

                    DeathController.calculateGompertz(a, b, totalPeople, normPercent);
                case "2":
                    totalPeople = readIntFromConsole("Input Total people: ");
                    normPercent = readDoubleFromConsole("Input norm of percent: ");
                    DeathController.calculateMoivre(totalPeople, normPercent);
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
        DeathController.calculateGompertz(0.05615, 0.00273, 100000, 0.09);
        DeathController.calculateMoivre( 100000, 0.02);
    }

}
