package readability;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        if (1 > args.length) {
            SimplePrinter.printHelp();
            //noinspection CallToSystemExit
            System.exit(1);
        }

        AllReader reader = new AllReader(args[0]);
        TextCalculator textCalculator = new TextCalculator(reader.fileRead());

        SimplePrinter simplePrinter = new SimplePrinter(textCalculator.getDataMap().get(CounterType.WORDS),
                textCalculator.getDataMap().get(CounterType.SENTENCES),
                textCalculator.getDataMap().get(CounterType.CHARACTERS),
                textCalculator.getDataMap().get(CounterType.SYLLABLES),
                textCalculator.getDataMap().get(CounterType.POLYSYLLABLES)
        );

        simplePrinter.printSourceMeasures();
        String aCase = simplePrinter.scanUserChoice();
        ReadabilityCalculator readabilityCalculator = new ReadabilityCalculator(textCalculator);
        if ("ALL".equals(aCase)) {
            readabilityCalculator.getReadAbilityMap().forEach((key, value) -> calcAndPrint(value, simplePrinter));
        } else {
            IReadability iReadability = readabilityCalculator.getReadAbilityMap().get(aCase);
            if (null != iReadability) {
                calcAndPrint(iReadability, simplePrinter);
            }
        }
    }

    public static void calcAndPrint(IReadability iReadability, SimplePrinter simplePrinter) {
        Double score = iReadability.getScore();
        Integer age = AutomatedReadabilityAge.findAge(Math.ceil(score));
        simplePrinter
                .printScoreAndAge(iReadability.getFullName() + ": %.2f (about %d year olds).", score, age);


    }
}
