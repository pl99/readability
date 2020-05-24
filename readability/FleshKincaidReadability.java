package readability;

public class FleshKincaidReadability implements IReadability {

    private final double sentences;
    private final double words;
    private final double syllables;

    public FleshKincaidReadability(double sentences, double words, double syllables) {
        this.sentences = sentences;
        this.words = words;
        this.syllables = syllables;
    }

    @Override
    public Double getScore() {
        return 0.39*(words/sentences) +
            11.8*(syllables/words) - 15.59;
    }
}
