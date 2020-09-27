package readability;

import java.util.regex.Pattern;

public class WordCounter implements ICounter {
    private final WorldSplitter splitter ;

    public WordCounter() {
        splitter = new WorldSplitter();
    }

    @Override
    public Double count(String text) {
        return (double) splitter.getWords(text).length;
    }

    @Override
    public CounterType getCounterType() {
        return CounterType.WORDS;
    }
}
