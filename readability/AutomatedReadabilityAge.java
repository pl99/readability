package readability;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AutomatedReadabilityAge {
    private static final Map<Double, Integer> indexAge;

    static {
        indexAge = new HashMap<>();
        indexAge.put(1.0, 5);
        indexAge.put(2.0, 6);
        indexAge.put(3.0, 7);
        indexAge.put(4.0, 9);
        indexAge.put(5.0, 10);
        indexAge.put(6.0, 11);
        indexAge.put(7.0, 12);
        indexAge.put(8.0, 13);
        indexAge.put(9.0, 14);
        indexAge.put(10.0, 15);
        indexAge.put(11.0, 16);
        indexAge.put(12.0, 17);
        indexAge.put(13.0, 18);
        indexAge.put(14.0, 24);
    }

    public static Integer findAge(Double key) {
        if (14.0 <= key) {
            return 24;
        }
        return indexAge.get(key);
    }

    public static Double calcAverage(Integer[] ages) {
        double average = Arrays.stream(ages)
                .mapToDouble(Double::valueOf)
                .average().getAsDouble();
        return average;
    }
}
