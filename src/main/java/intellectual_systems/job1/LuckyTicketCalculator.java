package intellectual_systems.job1;

import lombok.extern.slf4j.Slf4j;
import utility.ConverterUtil;

@Slf4j
public class LuckyTicketCalculator {

    public int getNumberOfTickets(int length, boolean printNumbers) {
        if (length % 2 != 0)
            throw new IllegalArgumentException("Ticket number length can't be an odd");

        var counter = 0;
        for(int i = 0; i < Math.pow(10 , length); i++) {
            var line = new StringBuilder(String.valueOf(i));
            while(line.length() < length) {
                line.insert(0, "0");
            }

            if(testNumber(line.toString())) {
                if(printNumbers)
                    log.info("Lucky ticket: {}", line);
                counter++;
            }
        }

        return counter;
    }

    public boolean testNumber(String line) {
        var median = line.length() / 2;
        var firstHalfSum = line.substring(0, median).chars().map(ConverterUtil::charToInt).sum();
        var secondHalfSum = line.substring(median).chars().map(ConverterUtil::charToInt).sum();
        return firstHalfSum == secondHalfSum;
    }
}
