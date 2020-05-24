package readability;

public class SmogIndex implements IReadability {
    private final double sentences;
    private final double polysyllables;

    public SmogIndex(double sentences, double polysyllables) {
        this.sentences = sentences;
        this.polysyllables = polysyllables;
    }

    @Override
    public Double getScore() {
        Double score = 1.043*Math.sqrt(polysyllables*(30/sentences))
                + 3.1291;
        return score;
    }
}
