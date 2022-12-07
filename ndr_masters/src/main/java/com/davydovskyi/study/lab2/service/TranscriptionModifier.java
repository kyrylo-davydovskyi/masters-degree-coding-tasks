package com.davydovskyi.study.lab2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static com.davydovskyi.study.utility.StringUtils.replaceCharByIndex;

public class TranscriptionModifier implements StringModifier {

    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";


    @Override
    public List<String> modifyString(String word) {
        var result = new ArrayList<String>();
        IntStream.rangeClosed(0, word.length() - 1).forEach(x ->
        {
            for (char letter : alphabet.toCharArray()) {
                if (letter != word.charAt(x))
                    result.add(replaceCharByIndex(word, x, letter));
            }
        });
        return result;
    }
}
