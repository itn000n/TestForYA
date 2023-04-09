package delivery;

import org.jetbrains.annotations.NotNull;

public class Delivery {
    public static double minCount = 400.0;

    public static double delivery(double distance,
                                  @NotNull  Size size,
                                  @NotNull  Fragile fragility,
                                  @NotNull  Traffic traffic) throws Exception {
        double sumOfDelivery = 0.0;

        sumOfDelivery+=Distance.find(distance).getRatio();

        sumOfDelivery += size.getRatio();


        sumOfDelivery += fragility.getRatio(distance);


        sumOfDelivery*=traffic.getRatio();

        return Math.max(sumOfDelivery, minCount);
    }

    public static void main(String[] args) throws Exception {
        delivery(1,null,null,null);
    }
}
