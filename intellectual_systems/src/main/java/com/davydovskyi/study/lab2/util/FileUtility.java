package com.davydovskyi.study.lab2.util;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

@Slf4j
public class FileUtility {

    @SneakyThrows
    public static int[][] readDataFromFile(String fileName) {
        var sc = new Scanner(new BufferedReader(new FileReader(fileName)));

        var queue = new LinkedBlockingQueue<List<Integer>>();
        while(sc.hasNextLine()) {
                var line = Arrays.stream(sc.nextLine().trim().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                queue.add(line);
            }
        var array = new int[queue.size()][queue.size()];
        var iter = 0;
        for (List<Integer> element : queue) {
            var temp = element.stream().mapToInt(i -> i).toArray();
            array[iter] = temp;
            iter++;
        }
        return array;
    }
}
