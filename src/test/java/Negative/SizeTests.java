package Negative;

import delivery.Delivery;
import delivery.Fragile;
import delivery.Size;
import delivery.Traffic;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.ThreadLocalRandom;

public class SizeTests {

    @Test(description = "Проверяем, что параметр хупкости не может быть null")
    public void sizeTestNonNull(){
        var distance = 31;
        var fragility = Fragile.FRAGILE;
        var traffic = Traffic.MEDIUM;

        Exception exception = new Exception("");
        try {
            Delivery.delivery(distance, null, fragility, traffic);
        } catch (Exception e) {
            exception=e;
        }

        Assert.assertEquals(exception.getMessage(),"Argument for @NotNull parameter 'size' of delivery/Delivery.delivery must not be null");
    }
}
