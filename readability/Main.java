package readability;

import java.io.IOException;
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

        Double ariScore = new AutomatedReadabilityIndex(sentences, words, characters).getScore();
        Double fkScore = new FleshKincaidReadability(sentences, words, syllables).getScore();
        Double smogScore = new SmogIndex(sentences, polysyllables).getScore();
        Double clScore = new ColemanLiauIndex(100 * characters / words, 100 * sentences / words).getScore();
        Integer ariAge = AutomatedReadabilityAge.findAge(Math.ceil(ariScore));
        Integer fKAge = AutomatedReadabilityAge.findAge(Math.ceil(fkScore));
        Integer smogAge = AutomatedReadabilityAge.findAge(Math.ceil(smogScore));
        Integer clAge = AutomatedReadabilityAge.findAge(Math.ceil(clScore));
        System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextLine().toUpperCase()) {
            case "ARI":
                simplePrinter
                        .printScoreAndAge("Automated Readability Index: %.2f (about %d year olds).", ariScore, ariAge);
                break;
            case "FK":
                simplePrinter
                        .printScoreAndAge("Flesch–Kincaid readability tests: %.2f (about %d year olds).", fkScore, fKAge);
                break;
            case "SMOG":
                simplePrinter
                        .printScoreAndAge("Simple Measure of Gobbledygook: %.2f (about %d year olds).", smogScore, smogAge);
                break;
            case "CL":
                simplePrinter
                        .printScoreAndAge("Coleman–Liau index: %.2f (about %d year olds).", clScore, clAge);
                break;
            case "ALL":
                simplePrinter
                        .printScoreAndAge("Automated Readability Index: %.2f (about %d year olds).", ariScore, ariAge);
                simplePrinter
                        .printScoreAndAge("Flesch–Kincaid readability tests: %.2f (about %d year olds).", fkScore, fKAge);
                simplePrinter
                        .printScoreAndAge("Simple Measure of Gobbledygook: %.2f (about %d year olds).", smogScore, smogAge);
                simplePrinter
                        .printScoreAndAge("Coleman–Liau index: %.2f (about %d year olds).", clScore, clAge);

                simplePrinter
                        .printScoreAndAge(
                                "This text should be understood in average by %.2f year olds.",
                                AutomatedReadabilityAge.calcAverage(new Integer[]{ariAge, fKAge, smogAge, clAge}),
                                0);
                break;
        }
        scanner.close();

    }
}
