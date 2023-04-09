package Negative;

import delivery.Delivery;
import delivery.Fragile;
import delivery.Size;
import delivery.Traffic;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.ThreadLocalRandom;

public class FragileTests {

    @Test(description = "Проверяем, что разница нет возможности выбрать доставку хрупкого груза на расстояние выше 30 км",
    dataProvider = "Fragile")
    public void fragilityTestRejection(double distance) {
        var size = Size.LARGE;
        var traffic = Traffic.CRITICAL;
        Exception exception = new Exception("");
        try {
            Delivery.delivery(distance, size, Fragile.FRAGILE, traffic);
        } catch (Exception e) {
            exception=e;
        }
        Assert.assertEquals(exception.getMessage(), "the distance cannot exceed 30 for fragile cargo");
    }

    @DataProvider(name = "Fragile")
    public Object[][] createData() {
        return new Object[][]{
                {ThreadLocalRandom.current().nextDouble(31, 1000)},
                {31.0}
        };
    }

    @Test(description = "Проверяем, что параметр хрупкости не может быть null")
    public void fragilityTestNonNull() {
        var distance = 31;
        var size = Size.LARGE;
        var traffic = Traffic.MEDIUM;

        Exception exception = new Exception("");
        try {
            Delivery.delivery(distance, size, null, traffic);
        } catch (Exception e) {
            exception=e;
        }

        Assert.assertEquals(exception.getMessage(),"Argument for @NotNull parameter 'fragility' of delivery/Delivery.delivery must not be null");
    }
}
