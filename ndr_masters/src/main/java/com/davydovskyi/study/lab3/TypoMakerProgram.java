package com.davydovskyi.study.lab3;

import com.davydovskyi.study.lab3.service.*;
import com.davydovskyi.study.utility.ConsoleUtil;
import com.davydovskyi.study.utility.FileUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


@Slf4j
public class TypoMakerProgram {

     private static final List<StringModifier> modifiers = List.of(
            new TranscriptionModifier(),
            new TranspositionModifier(),
            new DoubleTranspositionModifier(),
            new CharInserterModifier(),
            new CharRemoverModifier()
    );

    public static void main(String[] args) {

        var source = ConsoleUtil.readFromConsole("Input word to modify: ");

        modifiers.forEach(x -> {
            var result = x.modifyString(source);
            log.info("Algorithm {} generated {} values", x.getClass().getSimpleName(), result.size());
            FileUtils.writeToFile(generateFileName(x), result);
        });
    }

    private static String generateFileName(StringModifier stringModifier) {
        return stringModifier.getClass().getSimpleName() + "_result.txt";
    }
}
