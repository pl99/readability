package readability.calcs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class AutomatedReadabilityAge {
    private static final Map<Double, Integer> INDEX_AGE;

    static {
        INDEX_AGE = new HashMap<>();
        INDEX_AGE.put(1.0, 5);
        INDEX_AGE.put(2.0, 6);
        INDEX_AGE.put(3.0, 7);
        INDEX_AGE.put(4.0, 9);
        INDEX_AGE.put(5.0, 10);
        INDEX_AGE.put(6.0, 11);
        INDEX_AGE.put(7.0, 12);
        INDEX_AGE.put(8.0, 13);
        INDEX_AGE.put(9.0, 14);
        INDEX_AGE.put(10.0, 15);
        INDEX_AGE.put(11.0, 16);
        INDEX_AGE.put(12.0, 17);
        INDEX_AGE.put(13.0, 18);
        INDEX_AGE.put(14.0, 24);
    }

    public static Integer findAge(Double key) {
        if (14.0 <= key) {
            return 24;
        }
        return INDEX_AGE.get(key);
    }

    public static Double calcAverage(Integer[] ages) {
        double average = Arrays.stream(ages)
                .mapToDouble(Double::valueOf)
                .average().orElseThrow();
        return average;
    }
}
