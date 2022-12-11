package com.davydovskyi.study.lab3.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static com.davydovskyi.study.utility.StringUtils.addCharAt;

public class CharInserterModifier implements StringModifier {

    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    @Override
    public List<String> modifyString(String word) {
        var result = new ArrayList<String>();
        IntStream.rangeClosed(0, word.length()).forEach(x ->
        {
            for (char letter : alphabet.toCharArray()) {
                result.add(addCharAt(word, x, letter));
            }
        });
        return result;
    }
}
