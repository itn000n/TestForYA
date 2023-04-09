package Positive;

import delivery.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.ThreadLocalRandom;

public class SizeTests {

    @Test(description = "Проверяем, что наценка в зависимости от размера груза соответствует заявленной",
            dataProvider = "Size")
    public void sizeDifference(Size size, double count) throws Exception {
        var distance = ThreadLocalRandom.current().nextDouble(1, 30);
        var fragile = Fragile.FRAGILE;
        var traffic = Traffic.CRITICAL;

        var large = Delivery.delivery(distance, size, fragile, traffic);

        Assert.assertEquals((Distance.find(distance).getRatio() + count + fragile.getRatio(distance)) * traffic.getRatio(), large);
    }

    @DataProvider(name = "Size")
    public Object[][] createData() {
        return new Object[][]{
                {Size.LARGE, Size.LARGE.getRatio()},
                {Size.SMALL, Size.SMALL.getRatio()}
        };
    }
}
