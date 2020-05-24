package readability;

public class ColemanLiauIndex implements IReadability {

    private final double l;
    private final double s;

    public ColemanLiauIndex(double l, double s) {
        this.l = l;
        this.s = s;
    }

    @Override
    public Double getScore() {
        return 0.0588*l - 0.296*s - 15.8;
    }
}
