package readability;

import java.util.ArrayList;

public class PolysyllableCounter implements ICounter {
    double result = 0.0;
    SyllableCounter syllableCounter = new SyllableCounter();

    @Override
    public Double count(String text) {
        String[] words = new WorldSplitter().getWords(text);
        ArrayList<String> complexWords = new ArrayList<>();
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
