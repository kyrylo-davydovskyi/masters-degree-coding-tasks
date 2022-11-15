package com.davydovskyi.study.utility;

import java.util.HashMap;
import java.util.Map;

public class MapUtils {

    public static <T> Map<T, Double> mergeMaps(Map<T, Double> map1, Map<T, Double> map2) {
        var mergedMap = new HashMap<>(map1);
        map2.forEach((k, v) -> mergedMap.merge(k, v, Double::sum));
        return mergedMap;
    }

    public static <T> Map.Entry<T, Double> foundByMinValue(Map<T, Double> map) {
        return map.entrySet()
                .stream().min(Map.Entry.comparingByValue())
                .orElseThrow();
    }

    public static <T> Map.Entry<T, Double> foundByMaxValue(Map<T, Double> map) {
        return map.entrySet()
                .stream().max(Map.Entry.comparingByValue())
                .orElseThrow();
    }
}
