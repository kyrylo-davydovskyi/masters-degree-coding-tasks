package com.davydovskyi.study.lab2;

import com.davydovskyi.study.lab2.service.GompertzController;
import com.davydovskyi.study.lab2.service.MoivreController;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import static com.davydovskyi.study.utility.ConsoleUtil.*;

@Slf4j
public class ApplicationByDavydovskyi {


    @SneakyThrows
    public static void main(String... args) {

        do {
            var action = readFromConsole("Select workflow: 1 - Calculate statistic, 2 - Moivre approach, 3 - demo, 4 - exit");
            switch (action) {
                case "1":
                    createStatistic();
                    break;
                case "2":
                case "3":
                    demo();
                    break;
                case "4":
                    System.exit(0);
            }
        } while (true);
    }

    private static void createStatistic() {
        Integer totalPeople;
        Double normPercent;
        var action = readFromConsole("Select workflow: 1 - Calculate statistic, 2 - Moivre approach, 3 - demo, 4 - exit");
        switch (action) {
            case "1":
                var a = readDoubleFromConsole("Input a param: ");
                var b = readDoubleFromConsole("Input b param: ");
                totalPeople = readIntFromConsole("Input Total people: ");
                normPercent = readDoubleFromConsole("Input norm of percent: ");

                GompertzController.calculate(a, b, totalPeople, normPercent);
            case "2":
                totalPeople = readIntFromConsole("Input Total people: ");
                normPercent = readDoubleFromConsole("Input norm of percent: ");
                MoivreController.calculate(totalPeople, normPercent);
                break;
        }
    }

//    private static void dataDredging() {
//        var filePath = readFromConsole("Input path to file: ");
//
//        var action = readFromConsole("Select approach to dredge: 1 - Gompertz, 2 - Moivre");
//
//        var data = File
//
//        switch (action) {
//            case "1":
//            case "2":
//                break;
//        }
//    }



    private static void demo() {
        GompertzController.calculate(0.05615, 0.00273, 100000, 0.09);
        MoivreController.calculate( 100000, 0.02);
    }

}
