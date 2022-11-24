package com.davydovskyi.study.lab3;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class AlgorithmExecutor {

    public static double schema1(int a, int b, double x) {
        if (a > 1 && b == 0)
            x = x / a;
        if (a == 2 || x > 1.)
            x++;
        return x;
    }

    public static double schema1Broken01(int a, int b, double x) {
        if (a > 1 || b == 0)
            x = x / a;
        if (a == 2 || x > 1.)
            x++;
        return x;
    }

    public static double schema1Broken02(int a, int b, double x) {
        if (a > 1 && b == 0)
            x = x / a;
        if (a == 2 || x < 1.)
            x++;
        return x;
    }

    public static double schema1Broken03(int a, int b, double x) {
        if (a > 1 || b == 0)
            x = x / a;
        if (a == 2 || x < 1)
            x++;
        return x;
    }


    public static double schema2(int x) {
        if (x < -100 || x > 100)
            throw new RuntimeException("X supposed to be in Range(-100, 100)");

        if (x > 17)
            x = 17 - x;

        if (x == -13)
            x = 0;
        return x;
    }

    public static double schema2Broken01(int x) {
        if (x < -100 || x > 100)
            throw new RuntimeException("X supposed to be in Range(-100, 100)");

        if (x >= 17)
            x = 17 - x;

        if (x == -13)
            x = 0;
        return x;
    }

    public static double schema2Broken02(int x) {
        if (x < -100 || x > 100)
            throw new RuntimeException("X supposed to be in Range(-100, 100)");

        if (x > 17)
            x = x - 17;

        if (x == -13)
            x = 0;
        return x;
    }


    public static int schema3(int n, int x) {
        if (x < -100 || x > 100)
            throw new RuntimeException("X supposed to be in Range(-100, 100)");
        if (n < 0 || x > 10)
            throw new RuntimeException("N supposed to be in Range(0, 10)");

        var z = new AtomicInteger(1);

        IntStream.rangeClosed(1, n).forEach(i ->
                z.set(z.get() * i)
        );

        return z.get();
    }

    public static int schema3Brpken01(int n, int x) {
        if (x < -100 || x > 100)
            throw new RuntimeException("X supposed to be in Range(-100, 100)");
        if (n < 0 || x > 10)
            throw new RuntimeException("N supposed to be in Range(0, 10)");

        var z = new AtomicInteger(2);

        IntStream.rangeClosed(1, n).forEach(i ->
                z.set(z.get() * i)
        );

        return z.get();
    }

    public static int schema3Brpken02(int n, int x) {
        if (x < -100 || x > 100)
            throw new RuntimeException("X supposed to be in Range(-100, 100)");
        if (n < 0 || x > 10)
            throw new RuntimeException("N supposed to be in Range(0, 10)");

        var z = new AtomicInteger(1);

        IntStream.rangeClosed(0, n).forEach(i ->
                z.set(z.get() * i)
        );

        return z.get();
    }

    public static int schema3Brpken03(int n, int x) {
        if (x < -100 || x > 100)
            throw new RuntimeException("X supposed to be in Range(-100, 100)");
        if (n < 0 || x > 10)
            throw new RuntimeException("N supposed to be in Range(0, 10)");

        var z = new AtomicInteger(1);

        IntStream.rangeClosed(1, n - 1).forEach(i ->
                z.set(z.get() * i)
        );

        return z.get();
    }
}
