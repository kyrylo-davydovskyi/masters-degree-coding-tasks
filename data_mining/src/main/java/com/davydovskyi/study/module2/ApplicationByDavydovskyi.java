package com.davydovskyi.study.module2;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class ApplicationByDavydovskyi {


    private static double f1(double a, double b) {
        var res = ((Math.log(a) - Math.log(b)) / a) - 73.;
        log.info("f1(a={}, b={}) = {}", a, b, res);
        return res;
    }

    private static double f2(double a, double b) {
        var res = Math.exp((-b * ((Math.exp(25.75 * a)) - 1.)) / (a)) - 0.75;
        log.info("f2(a={}, b={}) = {}", a, b, res);
        return res;
    }

    private static double[] f(double a, double b) {
        var result = new double[2];
        result[0] = f1(a, b);
        result[1] = f2(a, b);
        return result;
    }

    private static double[][] fPrime(double a, double b) {
        var result = new double[2][2];
        var e2575a = Math.exp(25.75 * a);
        var eb1e2575a = Math.exp((b - e2575a * b) / a);

        result[0][0] = (Math.log(b) - Math.log(a) + 1.) / Math.pow(a, 2); //(1 / a) - ((Math.log(a) - Math.log(b)) / Math.pow(a, 2));
        result[0][1] = (-1. / (a * b));

        result[1][0] = (-25.75
                * b
                * (e2575a * (a - 0.038835) + 0.038835)
                * eb1e2575a)
                / Math.pow(a, 2);
        result[1][1] = ((e2575a - 1.) * eb1e2575a) / a;

        log.info("Prime matrix: {}", Arrays.deepToString(result));
        return result;
    }

    @SneakyThrows
    public static void main(String... args) {
        var a = 0.009;
        var b = 0.003;

        for (var i = 0; i < 4; i++) {

            var fVector = negateVector(f(a, b));
            var fPrimeMatrix = fPrime(a, b);

//            var deltaA = getDeltaA(fPrimeMatrix, fVector);
//            var deltaB = getDeltaB(fPrimeMatrix, fVector);
//            log.info("Delta for a={} and for b={}", deltaA, deltaB);
//            a = a + deltaA;
//            b = b + deltaB;


            var fRevertedMatrix = revertMatrix(fPrimeMatrix);
            a = a - (fRevertedMatrix[0][0] * fVector[0] + fRevertedMatrix[0][1] * fVector[1]);
            b = b - (fRevertedMatrix[1][0] * fVector[0] + fRevertedMatrix[1][1] * fVector[1]);
            log.info("New a={}, b={}", a, b);

            log.info("=====================================");
        }
    }


    private static double[] negateVector(double[] vector) {
        vector[0] = -1. * vector[0];
        vector[1] = -1. * vector[1];
        log.info("Changing sign in vector. Result: {}", vector);
        return vector;
    }

    private static double getDeltaA(double[][] matrix, double[] vector) {
        var det = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        log.info("D={}, {}", det, Arrays.deepToString(matrix));
        var detA = vector[0] * matrix[1][1] - vector[1] * matrix[0][1];
        log.info("Da={},  [{},{},{},{}]", detA, vector[0], matrix[0][1], vector[1], matrix[1][1]);
        return detA / det;
    }

    private static double getDeltaB(double[][] matrix, double[] vector) {
        var det = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
//        log.info("D={}, {}", det, Arrays.deepToString(matrix));
        var detB = vector[0] * matrix[0][0] - vector[1] * matrix[1][0];
        log.info("Db={}, [{},{},{},{}]", detB, matrix[0][0], vector[0], matrix[1][0], vector[1]);
        return detB / det;
    }


    private static double[][] revertMatrix(double[][] matrix) {
        var coeff = 1. / (matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0]);

        var result = new double[2][2];
        result[0][0] = coeff * matrix[1][1];
        result[0][1] = -1. * coeff * matrix[0][1];
        result[1][0] = -1. * coeff * matrix[1][0];
        result[1][1] = coeff * matrix[0][0];

        log.info("Reverting matrix. Result: {}", Arrays.deepToString(result));
        return result;
    }
}

