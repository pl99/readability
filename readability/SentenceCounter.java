package readability;

import java.util.regex.Pattern;

public class SentenceCounter implements ICounter {
    private static final Pattern SENTENCE_PATTERN = Pattern.compile("[\\.!\\?]+");

    @Override
    public Double count(String text) {
        return (double) SENTENCE_PATTERN.split(text).length;
    }

    @Override
    public CounterType getCounterType() {
        return CounterType.SENTENCES;
    }
}
