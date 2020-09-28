package readability.calcs;

import readability.counters.SmogIndex;
import readability.counters.TextCalculator;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static readability.counters.CounterType.*;

public class ReadabilityCalculator {
    private final Map<String, IReadability> readAbilityMap;


    public ReadabilityCalculator(TextCalculator textCalculator) {
        readAbilityMap = new HashMap<>();
        IReadability automatedReadabilityIndex = new AutomatedReadabilityIndex(
                textCalculator.getDataMap().get(SENTENCES),
                textCalculator.getDataMap().get(WORDS),
                textCalculator.getDataMap().get(CHARACTERS));
        IReadability fleshKincaidReadability = new FleshKincaidReadability(
                textCalculator.getDataMap().get(SENTENCES),
                textCalculator.getDataMap().get(WORDS),
                textCalculator.getDataMap().get(SYLLABLES));
        IReadability smogIndex = new SmogIndex(textCalculator.getDataMap().get(SENTENCES),
                textCalculator.getDataMap().get(POLYSYLLABLES));

        IReadability colemanLiauIndex =
                new ColemanLiauIndex((100 * textCalculator.getDataMap().get(CHARACTERS)) /
                        textCalculator.getDataMap().get(WORDS)
                        , (100 * textCalculator.getDataMap().get(SENTENCES)) /
                        textCalculator.getDataMap().get(WORDS));

        readAbilityMap.put(automatedReadabilityIndex.getCounterType(), automatedReadabilityIndex);
        readAbilityMap.put(fleshKincaidReadability.getCounterType(), fleshKincaidReadability);
        readAbilityMap.put(smogIndex.getCounterType(), smogIndex);
        readAbilityMap.put(colemanLiauIndex.getCounterType(), colemanLiauIndex);
    }


    public Map<String, IReadability> getReadAbilityMap() {
        return Collections.unmodifiableMap(readAbilityMap);
    }
}
