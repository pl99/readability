package readability;

public class SimplePrinter {
    private final Double words ;
    private final Double sentences ;
    private final Double characters;
    private final Double syllables ;
    private final Double polysyllables ;

    public SimplePrinter(Double words, Double sentences, Double characters, Double syllables, Double polysyllables) {
        this.words = words;
        this.sentences = sentences;
        this.characters = characters;
        this.syllables = syllables;
        this.polysyllables = polysyllables;
    }

    public void printSourceMeashures(){
        System.out.println("Words: " + words);
        System.out.println("Sentences: " + sentences);
        System.out.println("Characters: " + characters);
        System.out.println("Syllables: " + syllables);
        System.out.println("Polysyllables: " + polysyllables);
    }

    public void printScoreAndAge(String fmtString, Double score, Integer age){
        System.out.println(String.format(fmtString, score, age));
    }
}
