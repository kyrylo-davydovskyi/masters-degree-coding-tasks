package com.davydovskyi.study.lab2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static com.davydovskyi.study.utility.StringUtils.deleteCharAt;

public class CharRemoverModifier implements StringModifier {
    @Override
    public List<String> modifyString(String word) {
        var result = new ArrayList<String>();
        IntStream.rangeClosed(0, word.length() - 1)
                .forEach(x -> result.add(deleteCharAt(word, x)));
        return result;
    }
}
