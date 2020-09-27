package readability;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextCalculator {
    private Map<CounterType, Double> dataMap;
    private Map<CounterType, ICounter> counters;

    {
        dataMap = new HashMap<>();
        counters = new HashMap<>();
        counters.put(CounterType.WORDS, new WordCounter());
        counters.put(CounterType.SENTENCES, new SentenceCounter());
        counters.put(CounterType.CHARACTERS, new CharacterCounter());
        counters.put(CounterType.SYLLABLES, new SyllableCounter());
        counters.put(CounterType.POLYSYLLABLES, new PolysyllableCounter());
    }

    public TextCalculator(String data) {
        counters.values().forEach(it -> dataMap.put(it.getCounterType(), it.count(data)));
    }

    public Map<CounterType, Double> getDataMap() {
        return dataMap;
    }

    public Map<CounterType, ICounter> getCounters() {
        return counters;
    }
}
