package Negative;

import delivery.Delivery;
import delivery.Fragile;
import delivery.Size;
import delivery.Traffic;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.ThreadLocalRandom;

public class TrafficTests {

    @Test(description = "Проверяем, что параметр траффика не может быть null")
    public void trafficTestNonNull(){
        var distance = 31;
        var fragility = Fragile.FRAGILE;
        var size = Size.LARGE;

        Exception exception = new Exception("");
        try {
            Delivery.delivery(distance, size, fragility, null);
        } catch (Exception e) {
            exception=e;
        }

        Assert.assertEquals(exception.getMessage(),"Argument for @NotNull parameter 'traffic' of delivery/Delivery.delivery must not be null");
    }
}
