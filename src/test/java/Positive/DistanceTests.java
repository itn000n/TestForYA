package Positive;

import delivery.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.ThreadLocalRandom;

public class DistanceTests {

    @Test(description = "Проверяем, что наценка в зависимости от расстояние соответствует заявленной",
            dataProvider = "Distance")
    public void multiplierDifference(double distance, double count) throws Exception {
        var fragile = Fragile.NONFRAGILE;
        var size = Size.LARGE;
        var traffic = Traffic.CRITICAL;

        var sum = Delivery.delivery(distance, size, fragile, traffic);

        Assert.assertEquals((count + size.getRatio() + fragile.getRatio(distance)) * traffic.getRatio(), sum);
    }

    @DataProvider(name = "Distance")
    public Object[][] createData() {
        return new Object[][]{
                {0.1, Distance.LOW.getRatio()},
                {2, Distance.LOW.getRatio()},
                {2.1, Distance.MEDIUM.getRatio()},
                {10, Distance.MEDIUM.getRatio()},
                {10.1, Distance.HIGH.getRatio()},
                {30, Distance.HIGH.getRatio()},
                {30.1, Distance.HIGHEST.getRatio()},
                {1000, Distance.HIGHEST.getRatio()}
        };
    }
}
