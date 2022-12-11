package com.davydovskyi.study.lab3.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static com.davydovskyi.study.utility.StringUtils.swapChars;

public class TranspositionModifier implements StringModifier {
    @Override
    public List<String> modifyString(String word) {
        var result = new ArrayList<String>();
        IntStream.rangeClosed(0, word.length() - 2).forEach(x ->
        {
            if (word.charAt(x + 1) != word.charAt(x))
                result.add(swapChars(word, x, x + 1));
        });
        return result;
    }
}
