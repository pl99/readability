package readability.counters;

public interface ICounter {
    Double count(String text);
    CounterType getCounterType();
}
