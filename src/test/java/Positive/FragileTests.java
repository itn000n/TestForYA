package Positive;

import delivery.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.ThreadLocalRandom;

public class FragileTests {

    @Test(description = "Проверяем, что разница между доставкой хрупкого груза и нет составляет 300")
    public void fragilityTestDifference() throws Exception {
        var distance = 30.0;
        var size = Size.LARGE;
        var traffic = Traffic.CRITICAL;

        var sumFragile = Delivery.delivery(distance, size, Fragile.FRAGILE, traffic);
        var sumNotFragile = Delivery.delivery(distance, size, Fragile.NONFRAGILE, traffic);

        Assert.assertEquals(sumFragile / traffic.getRatio() - sumNotFragile / traffic.getRatio(), 300.0);
    }


    @Test(description = "Проверяем, что нет наценки при отсутствии признака хрупкого груза")
    public void fragilityTestNonCount() throws Exception {
        var distance = ThreadLocalRandom.current().nextDouble(11, 30);
        var size = Size.LARGE;
        var fragile = Fragile.NONFRAGILE;
        var traffic = Traffic.MEDIUM;
        var sumNotFragile = Delivery.delivery(distance, size, fragile, traffic);

        Assert.assertEquals(traffic.getRatio() * (Distance.find(distance).getRatio() + size.getRatio()), sumNotFragile);
    }
}
