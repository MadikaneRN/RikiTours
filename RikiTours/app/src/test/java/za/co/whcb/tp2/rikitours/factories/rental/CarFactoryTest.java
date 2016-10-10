package za.co.whcb.tp2.rikitours.factories.rental;

import org.junit.Assert;
import org.junit.Test;

import za.co.whcb.tp2.rikitours.domain.rental.Car;

/**
 * Created by berka on 10/10/2016.
 */
public class CarFactoryTest {

    @Test
    public void testGetCar() throws Exception
    {

        Car car = CarFactory.getCar("CA-7889","SUV");
        Assert.assertNotNull(car);
        Assert.assertEquals(car.getCarType(),"SUV");
    }
}
