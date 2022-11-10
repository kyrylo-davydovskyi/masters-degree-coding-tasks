package com.davydovskyi.study;

import com.davydovskyi.study.lab2.service.DeathController;
import com.davydovskyi.study.lab2.util.CsvPrinter;
import org.junit.jupiter.api.Test;

public class DeathCalculatorTest {

    @Test
    public void demonstrateGompertz() {
        var response = DeathController.calculateGompertz(0.05615, 0.00273,  100000, 0.09);

        CsvPrinter.createCsvReport("Gompretz_Calculator_By_Davydovskyi", response);
    }

    @Test
    public void demonstrateMoivre() {
        var response = DeathController.calculateMoivre(  100000, 0.09);
        CsvPrinter.createCsvReport("Moivre_Calculator_By_Davydovskyi", response);
    }
}
