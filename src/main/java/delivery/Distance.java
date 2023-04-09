package delivery;

import java.util.Arrays;

public enum Distance {
    HIGHEST(30.0, 1000.0, 300.0),
    HIGH(10.0, 30.0, 200.0),
    MEDIUM(2.0, 10.0, 100.0),
    LOW(0.0, 2.0, 50.0);

    private final double min;
    private final double max;
    private final double ratio;

    Distance(double min, double max, double ratio) {
        this.min = min;
        this.max = max;
        this.ratio = ratio;
    }

    public double getRatio() {
        return ratio;
    }

    public static Distance find(double distance) throws Exception {

        var dis = Arrays.stream(Distance.values()).filter(it -> it.min < distance && distance <= it.max).findFirst();
        if (dis.isPresent()) {
            return dis.get();
        } else {
            throw new Exception("distance is must be from 0 to 1000");
        }
    }
}
