package delivery;

public enum Fragile {
    FRAGILE(300.0, false),
    NONFRAGILE(0.0, true);

    private final double ratio;
    private final boolean availability;

    Fragile(double ratio, boolean availability) {

        this.ratio = ratio;
        this.availability = availability;

    }

    public double getRatio(double distance) throws Exception {
        if (distance > 30.0 && !availability) {
            throw new Exception("the distance cannot exceed 30 for fragile cargo");
        }
        return ratio;
    }
}
