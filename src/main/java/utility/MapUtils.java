package utility;

import java.util.Map;

public class MapUtils {

    public static <T> Map<T, Double> mergeMaps(Map<T, Double> map1, Map<T, Double> map2) {
        map2.forEach((k, v) -> map1.merge(k, v, Double::sum));
        return map1;
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
