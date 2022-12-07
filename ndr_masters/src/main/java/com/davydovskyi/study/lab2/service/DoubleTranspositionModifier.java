package com.davydovskyi.study.lab2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static com.davydovskyi.study.utility.StringUtils.swapChars;

public class DoubleTranspositionModifier implements StringModifier {
    @Override
    public List<String> modifyString(String word) {
        var result = new ArrayList<String>();
        IntStream.rangeClosed(0, word.length() - 2).forEach(x ->
                IntStream.rangeClosed(x, word.length() - 1).forEach(y -> {
                            if (Math.abs(x - y) >= 2
                                    && word.charAt(x) != word.charAt(y))
                                result.add(swapChars(word, x, y));
                        }
                ));
        return result;
    }
}
