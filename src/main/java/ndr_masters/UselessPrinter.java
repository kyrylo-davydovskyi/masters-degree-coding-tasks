package ndr_masters;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UselessPrinter {

    public void task6(int n) {
        if (n < 1)
            throw new IllegalArgumentException("N cant be less then 1");

        for (int i = 1; i<n; i++) {
            var line = new StringBuilder();
            for (int j = i; j<=n; j++) {
                line.append(String.format("(%s,%s)", i, j));
            }
            log.info(line.toString());
        }
    }
}
