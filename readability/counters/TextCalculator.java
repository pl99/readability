package readability.counters;

import readability.calcs.CharacterCounter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TextCalculator {
    private final Map<CounterType, Double> dataMap;
    private final Map<CounterType, ICounter> counters;

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
        return Collections.unmodifiableMap(dataMap);
    }

    public Map<CounterType, ICounter> getCounters() {
        return Collections.unmodifiableMap(counters);
    }
}
