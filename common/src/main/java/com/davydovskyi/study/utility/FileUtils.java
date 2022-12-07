package com.davydovskyi.study.utility;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Slf4j
public class FileUtils {

    @SneakyThrows
    public static void writeToFile(String fileName, List<String> lines) {

        createFile(fileName);

        var myWriter = new FileWriter(fileName);
        lines.forEach(x -> {
            try {
                myWriter.write(x);
                myWriter.write("\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        myWriter.close();
        log.debug("Written successfully to file {}", fileName);
    }

    @SneakyThrows
    public static void createFile(String fileName) {
        var file = new File(fileName);

        var result = file.createNewFile();
        if (result) {
            log.debug("File {} created successfully", fileName);
        }
        else {
            log.warn("File {} already exist", fileName);
        }
    }
}
