package readability;

public class AutomatedReadabilityIndex implements IReadability {
    private final double sentences;
    private final double words;
    private final double characters;

    public AutomatedReadabilityIndex(double sentences, double words, double characters) {
        this.sentences = sentences;
        this.words = words;
        this.characters = characters;
    }

    @Override
    public Double getScore() {
        return 4.71D * (characters / words) +
                0.5D * (words / sentences) -
                21.43D;
//        fscore = (Math.round(fscore * 100.0) / 100.0);
    }
}
