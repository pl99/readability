package readability;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        AllReader reader = new AllReader(args[0]);
        String data = reader.fileRead();
        Double words = new WordCounter().count(data);
        Double sentences = new SentenceCounter().count(data);
        Double characters = new CharacterCounter().count(data);
        Double syllables = new SyllableCounter().count(data);
        Double polysyllables = new PolysyllableCounter().count(data);
        SimplePrinter simplePrinter = new SimplePrinter(words, sentences, characters, syllables, polysyllables);

        simplePrinter.printSourceMeashures();

        HashMap<String, IReadability> readAbilityMap = new HashMap<>();
        AutomatedReadabilityIndex automatedReadabilityIndex = new AutomatedReadabilityIndex(sentences, words, characters);
        FleshKincaidReadability fleshKincaidReadability = new FleshKincaidReadability(sentences, words, syllables);
        SmogIndex smogIndex = new SmogIndex(sentences, polysyllables);
        ColemanLiauIndex colemanLiauIndex = new ColemanLiauIndex(100 * characters / words, 100 * sentences / words);
        readAbilityMap.put(automatedReadabilityIndex.getCounterType(), automatedReadabilityIndex);
        readAbilityMap.put(fleshKincaidReadability.getCounterType(), fleshKincaidReadability);
        readAbilityMap.put(smogIndex.getCounterType(), smogIndex);
        readAbilityMap.put(colemanLiauIndex.getCounterType(), colemanLiauIndex);
        System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        String aCase = scanner.nextLine().toUpperCase();
        scanner.close();
        if ("ALL".equals(aCase)) {
            readAbilityMap.forEach((key, value) -> calcAndPrint(value, simplePrinter));
        } else {
            IReadability iReadability = readAbilityMap.get(aCase);
            if (null != iReadability) {
                calcAndPrint(iReadability, simplePrinter);
            }
        }
    }

    public static void calcAndPrint(IReadability iReadability, SimplePrinter simplePrinter) {
        Double score = iReadability.getScore();
        Integer age = AutomatedReadabilityAge.findAge(Math.ceil(score));
        simplePrinter
                .printScoreAndAge(iReadability.getCounterType() + ": %.2f (about %d year olds).", score, age);


    }
}
