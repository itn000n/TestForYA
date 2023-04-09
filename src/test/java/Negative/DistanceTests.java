package Negative;

import delivery.Delivery;
import delivery.Fragile;
import delivery.Size;
import delivery.Traffic;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.ThreadLocalRandom;

public class DistanceTests {

    @Test(description = "Проверяем, что нет возможности заказть доставку на некорректное расстояние",
    dataProvider = "Distance")
    public void distanceTestRejection(double distance) {
        var size = Size.LARGE;
        var traffic = Traffic.CRITICAL;
        Exception exception = new Exception("");
        try {
            Delivery.delivery(distance, size, Fragile.FRAGILE, traffic);
        } catch (Exception e) {
            exception=e;
        }
        Assert.assertEquals(exception.getMessage(), "distance is must be from 0 to 1000");
    }

    @DataProvider(name = "Distance")
    public Object[][] createData() {
        return new Object[][]{
                {-0.1},
                {0.0},
                {1000.1}
        };
    }
}
