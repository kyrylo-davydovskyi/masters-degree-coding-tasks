package com.davydovskyi.study.lab2.service;

import java.util.*;

public class DemucronService {

    public static Map<Integer, List<Integer>> sortGraph(int size, int[][] graphArray) {
        var alreadySorted = new ArrayList<>();
        var resultMap = new HashMap<Integer, List<Integer>>();
        var iteration = 0;

        while (alreadySorted.size() < size) {
            var tempSorted = new ArrayList<>();

            for (int node = 0; node < size; node++) {
                if (alreadySorted.contains(node)) continue;

                var rowSum = 0;

                for (int subNode = 0; subNode < size; subNode++) {
                    if (!alreadySorted.contains(subNode)) {
                        rowSum += graphArray[node][subNode];
                    }
                }

                if (rowSum == 0) {
                    tempSorted.add(node);
                    var result = Optional.ofNullable(resultMap.get(iteration)).orElse(new ArrayList<>());
                    result.add(node);
                    resultMap.put(iteration, result);
                }
            }
            alreadySorted.addAll(tempSorted);
            iteration++;
        }
        return resultMap;
    }
}
