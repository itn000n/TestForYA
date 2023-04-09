package delivery;

public enum Traffic {
    CRITICAL(1.6),
    HIGH(1.4),
    MEDIUM(1.2),
    LOW(1.0);
    private final double ratio;
    Traffic(double v) {
        this.ratio = v;
    }

    public double getRatio() {
        return ratio;
    }
}
