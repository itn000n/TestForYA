package Positive;

import delivery.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.ThreadLocalRandom;

public class TrafficTests {

    @Test(description = "Проверяем, что наценка в зависимости от траффика соответствует заявленной",
            dataProvider = "Traffic")
    public void multiplierDifference(Traffic traffic, double count) throws Exception {
        var distance = ThreadLocalRandom.current().nextDouble(1, 30);
        var fragile = Fragile.FRAGILE;
        var size = Size.LARGE;

        var sum = Delivery.delivery(distance, size, fragile, traffic);

        Assert.assertEquals((Distance.find(distance).getRatio() + size.getRatio() + fragile.getRatio(distance)) * count, sum);
    }

    @DataProvider(name = "Traffic")
    public Object[][] createData() {
        return new Object[][]{
                {Traffic.LOW, Traffic.LOW.getRatio()},
                {Traffic.MEDIUM, Traffic.MEDIUM.getRatio()},
                {Traffic.HIGH, Traffic.HIGH.getRatio()},
                {Traffic.CRITICAL, Traffic.CRITICAL.getRatio()}
        };
    }
}
