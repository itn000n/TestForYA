package delivery;

public enum Size {
    LARGE(200.0),
    SMALL(100.0);

    private final double ratio;

    Size(double ratio) {

        this.ratio = ratio;

    }

    public double getRatio() {
        return ratio;
    }
}
