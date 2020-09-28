package readability.util;

import java.util.Scanner;

import static java.lang.System.out;

@SuppressWarnings("UseOfSystemOutOrSystemErr")
public class SimplePrinter {
    private final Double words;
    private final Double sentences;
    private final Double characters;
    private final Double syllables;
    private final Double polysyllables;

    public SimplePrinter(Double words, Double sentences, Double characters, Double syllables, Double polysyllables) {
        this.words = words;
        this.sentences = sentences;
        this.characters = characters;
        this.syllables = syllables;
        this.polysyllables = polysyllables;
    }

    public void printSourceMeasures() {
        out.println("Words: " + words);
        out.println("Sentences: " + sentences);
        out.println("Characters: " + characters);
        out.println("Syllables: " + syllables);
        out.println("Polysyllables: " + polysyllables);
    }

    public void printScoreAndAge(String fmtString, Double score, Integer age) {
        out.println(String.format(fmtString, score, age));
    }

    public String scanUserChoice() {
        out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
        out.println();
        String aCase;
        try (Scanner scanner = new Scanner(System.in)) {
            aCase = scanner.nextLine().toUpperCase();
        }
        return aCase;
    }

    public static void printHelp(){
        out.println("Usage:");
        out.println(" input text file name? please.");
    }
}
