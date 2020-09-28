package readability.counters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PolysyllableCounter implements ICounter {
    private double result = 0.0;
    private final SyllableCounter syllableCounter = new SyllableCounter();

    @Override
    public Double count(String text) {
        String[] words = new WorldSplitter().getWords(text);
        Collection<String> complexWords = new ArrayList<>();
        for (String word : words) {
            Double syllableCnt = syllableCounter.syllableInWord(word);
            if (2 < syllableCnt) {
                result += 1.0;
                complexWords.add(word);
            }
        }
        return result;
    }

    @Override
    public CounterType getCounterType() {
        return CounterType.POLYSYLLABLES;
    }
}
