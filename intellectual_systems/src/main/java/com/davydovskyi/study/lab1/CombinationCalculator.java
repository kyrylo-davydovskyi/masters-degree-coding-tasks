package com.davydovskyi.study.lab1;

import com.davydovskyi.study.utility.MathUtils;

public class CombinationCalculator {

    public static int getCombinationWithoutRepeats(int total, int required) {
        return (MathUtils.factorial(total))/(MathUtils.factorial(required) * MathUtils.factorial(total - required));
    }
    public static int getCombinationWithRepeats(int total, int required) {
        return (MathUtils.factorial(total + required - 1))/(MathUtils.factorial(required) * MathUtils.factorial(total - 1));
    }

}
