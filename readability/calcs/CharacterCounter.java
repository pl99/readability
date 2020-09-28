package readability.calcs;

import readability.counters.CounterType;
import readability.counters.ICounter;

public class CharacterCounter implements ICounter {
    @Override
    public Double count(String text) {
        return (double) text.chars()
                .mapToObj(it -> (char) it)
                .filter(c -> !Character.isWhitespace(c))
                .count();
    }

    @Override
    public CounterType getCounterType() {
        return CounterType.CHARACTERS;
    }
}
