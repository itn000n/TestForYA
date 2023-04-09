package Positive;

import delivery.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MainTests {

    @Test(description = "Проверяем, что если сумма доставки меньше минимальной, то в результате получаем минимальную")
    public void multiplierDifference() throws Exception {
        var distance = 1.0;
        var fragile = Fragile.NONFRAGILE;
        var size = Size.SMALL;
        var traffic = Traffic.LOW;

        var sum = Delivery.delivery(distance, size, fragile, traffic);

        Assert.assertTrue((distance + size.getRatio() + fragile.getRatio(distance)) * traffic.getRatio()<Delivery.minCount);
        Assert.assertEquals(sum, Delivery.minCount);
    }
}
